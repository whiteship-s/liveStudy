package whiteship.toyproject.livestudy.github.api;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import whiteship.toyproject.livestudy.common.model.*;
import whiteship.toyproject.livestudy.common.repository.*;

import java.io.IOException;
import java.util.List;

public class LiveStudyRunner  {

  private static final Logger LOGGER = LoggerFactory.getLogger(LiveStudyRunner.class);

  private final GithubApi githubApi;
  private final StudyInfoRepository studyInfoRepository;
  private final CommentRepository commentRepository;
  private final StudyWorkRepository studyWorkRepository;
  private final UserInfoRepository userInfoRepository;
  private final StudyCommentSiteRepository studyCommentSiteRepository;
  private final EmojiRepository emojiRepository;

  public LiveStudyRunner(GithubApi githubApi, StudyInfoRepository studyInfoRepository, CommentRepository commentRepository, StudyWorkRepository studyWorkRepository, UserInfoRepository userInfoRepository, StudyCommentSiteRepository studyCommentSiteRepository, EmojiRepository emojiRepository) {
    this.githubApi = githubApi;
    this.studyInfoRepository = studyInfoRepository;
    this.commentRepository = commentRepository;
    this.studyWorkRepository = studyWorkRepository;
    this.userInfoRepository = userInfoRepository;
    this.studyCommentSiteRepository = studyCommentSiteRepository;
    this.emojiRepository = emojiRepository;
  }

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
            .parallelStream()
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
    String[] works = githubApi.validCheckHaveStudyWork(ghIssue);
    if(works.length == 2) {
      studyWorkRepository.save(StudyWork.transformToStudyWork(studyInfo,  works[1], 1, 1));
    } else if (works.length  > 2) {
       works = githubApi.splitStudyWorkList(ghIssue);
      for (int i = 1; i < works.length; i++) {
        studyWorkRepository.save(StudyWork.transformToStudyWork(studyInfo, works[i], i, 0));
      }
    }
  }

}
