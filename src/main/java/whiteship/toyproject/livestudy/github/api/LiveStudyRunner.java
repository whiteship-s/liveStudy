package whiteship.toyproject.livestudy.github.api;

import org.kohsuke.github.GHIssue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import whiteship.toyproject.livestudy.common.model.StudyInfo;
import whiteship.toyproject.livestudy.common.repository.CommentRepository;
import whiteship.toyproject.livestudy.common.repository.StudyInfoRepository;

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

  @Override
  public void run(ApplicationArguments args) throws Exception {

    LOGGER.info("============== START ETL ==============");

//        extract StudyInfo list
    List<GHIssue> ghIssues = githubApi.extractStudyInfoInGithub();

//		save Issues
    ghIssues.forEach(this::loading);

  }

  private void loading(GHIssue ghIssue) {
    try {
      LOGGER.info("save..." + githubApi.transformToStudyInfo(ghIssue));
      StudyInfo studyInfo = studyInfoRepository.save(githubApi.transformToStudyInfo(ghIssue));

      ghIssue.getComments()
              .forEach(comment ->
                      commentRepository.save(githubApi.transformToCommentInfo(comment, studyInfo)));


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
