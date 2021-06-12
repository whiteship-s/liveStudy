package whiteship.toyproject.livestduy.controller;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestduy.access.CommentAccess;
import whiteship.toyproject.livestduy.access.StudyInfoAccess;
import whiteship.toyproject.livestduy.access.StudyInfoDto;
import whiteship.toyproject.livestduy.model.Comment;
import whiteship.toyproject.livestduy.model.StudyInfo;
import whiteship.toyproject.livestduy.repository.CommentRepository;
import whiteship.toyproject.livestduy.repository.StudyInfoRepository;

@Component
public class InputDataBase implements ApplicationRunner {

  private static final String MY_PERSONAL_TOKEN = "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";
  private final StudyInfoRepository studyInfoRepository;
  private final StudyInfoAccess studyInfoAccess;
  private final CommentRepository commentRepository;
  private final CommentAccess commentAccess;

  public InputDataBase(StudyInfoRepository studyInfoRepository,
      StudyInfoAccess studyInfoAccess, CommentRepository commentRepository,
      CommentAccess commentAccess) {
    this.studyInfoRepository = studyInfoRepository;
    this.studyInfoAccess = studyInfoAccess;
    this.commentRepository = commentRepository;
    this.commentAccess = commentAccess;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    GitHub github = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();

    //Repository 연결
    GHRepository repository = github.getRepository("whiteship/live-study");

    // 주차별로 db에 저장
    for (int i = 12; i <= 15; i++) {
      StudyInfoDto studyInfoDto = studyInfoAccess.save(repository.getIssue(i));
      StudyInfo info = studyInfoRepository.save(new StudyInfo(studyInfoDto));
      ExecutorService service = Executors.newFixedThreadPool(studyInfoDto.getParticipation());
      for (GHIssueComment comment : studyInfoDto.getComments()) {
        service.execute(() -> {
          try {
            commentRepository.save(new Comment(commentAccess.save(comment, info)));
          } catch (IOException e) {
            e.printStackTrace();
          }
        });
      }
      service.shutdown();
    }
  }
}
