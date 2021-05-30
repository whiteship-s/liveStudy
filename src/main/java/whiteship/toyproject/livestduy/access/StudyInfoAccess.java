package whiteship.toyproject.livestduy.access;

import java.io.IOException;
import org.kohsuke.github.GHIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestduy.repository.StudyInfoRepository;

@Component
public class StudyInfoAccess {

  @Autowired
  private StudyInfoRepository studyInfoRepository;

  public StudyInfoDto save(GHIssue issue) throws IOException {
    return StudyInfoDto.builder().title(issue.getTitle())
        .week(issue.getNumber())
        .learn(issue.getBody().split("# [가-힣]+")[1].strip())
        .goal(issue.getBody().split("# [가-힣\\s()]+")[2].strip())
        .participation(issue.getCommentsCount())
        .comments(issue.getComments())
        .build();
  }
}
