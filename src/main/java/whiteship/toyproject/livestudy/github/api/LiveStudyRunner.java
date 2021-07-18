package whiteship.toyproject.livestudy.github.api;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import whiteship.toyproject.livestudy.common.model.*;
import whiteship.toyproject.livestudy.common.repository.*;

import java.io.IOException;
import java.util.List;

@Configuration
public class LiveStudyRunner implements ApplicationRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(LiveStudyRunner.class);

  @Autowired
  GithubApi githubApi;

  @Autowired
  StudyInfoRepository studyInfoRepository;

  @Autowired
  CommentRepository commentRepository;

  @Autowired
  StudyWorkRepository studyWorkRepository;

  @Autowired
  UserInfoRepository userInfoRepository;

  @Autowired
  StudyCommentSiteRepository studyCommentSiteRepository;

  @Autowired
  EmojiRepository emojiRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    LOGGER.info("============== START ISSUES ETL ==============");

//        extract issues list
    List<GHIssue> ghIssues = githubApi.extractStudyInfoInGithub();

//		save Issues
    ghIssues.forEach(this::loading);


    LOGGER.info("============== END ISSUES ETL ==============");

  }

  private void loading(GHIssue ghIssue) {
    try {
      if(githubApi.validCheckIsStudy(ghIssue)) {

//        studyinfo
        StudyInfo studyInfo = studyInfoRepository.save(StudyInfo.transformToStudyInfo(ghIssue));

//        studywork
        extractingStudyWork(ghIssue, studyInfo);

//        comment | user | site | emoji
        extractingCommentRelatedInfo(ghIssue, studyInfo);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private void extractingCommentRelatedInfo(GHIssue ghIssue, StudyInfo studyInfo) throws IOException {
    ghIssue.getComments()
            .forEach(comment -> {
              try {

                UserInfo userInfo = extractingUserInfo(comment);

                StudyComment studyComment = extractingStudyComment(studyInfo, comment, userInfo);

                extractingStudyCommentSites(comment, studyComment);

                extractingEmojis(comment, studyComment);


              } catch (IOException e) {
                e.printStackTrace();
              }});
  }

  private void extractingEmojis(GHIssueComment comment, StudyComment studyComment) {
    List<Emoji> emojis = Emoji.getEmojis(studyComment, comment);
    emojiRepository.saveAll(emojis);
  }

  private void extractingStudyCommentSites(org.kohsuke.github.GHIssueComment comment, StudyComment studyComment) {
    List<StudyCommentSite> studyCommentSites = StudyCommentSite.getStudyCommentSites(studyComment, comment.getBody());
    studyCommentSiteRepository.saveAll(studyCommentSites);
  }

  private StudyComment extractingStudyComment(StudyInfo studyInfo, org.kohsuke.github.GHIssueComment comment, UserInfo userInfo) throws IOException {
    StudyComment studyComment = StudyComment.transformToStudyComment(comment, studyInfo, userInfo);
    commentRepository.save(studyComment);
    return studyComment;
  }

  private UserInfo extractingUserInfo(org.kohsuke.github.GHIssueComment comment) throws IOException {
    UserInfo userInfo = UserInfo.transformToUserInfo(comment.getUser());
    userInfoRepository.save(userInfo);
    return userInfo;
  }

  private void extractingStudyWork(GHIssue ghIssue, StudyInfo studyInfo) {
    //      extracting studywork list
    String[] worklist = githubApi.validCheckHaveStudyWork(ghIssue);
    if(worklist.length == 2) {
      studyWorkRepository.save(StudyWork.transformToStudyWork(studyInfo,  worklist[1], 1, 1));
    } else if (worklist.length  > 2) {
       worklist = githubApi.splitStudyWorkList(ghIssue);
      for (int i = 1; i < worklist.length; i++) {
        studyWorkRepository.save(StudyWork.transformToStudyWork(studyInfo, worklist[i], i, 0));
      }
    }
  }

}
