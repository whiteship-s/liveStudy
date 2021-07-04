package whiteship.toyproject.livestudy.github.api;


import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

import java.io.IOException;
import java.util.List;

import static whiteship.toyproject.livestudy.common.library.DateFormat.asLocalDateTime;


@Component
public class GithubApi {


  @Value("${github.token}")
  private String ACCESS_TOKEN_FOR_GITHUB;

  private static final String STUDY_URL = "whiteship/live-study";


  public List<GHIssue> extractStudyInfoInGithub() throws IOException {
    return getGhIssuesList();

  }

  public List<GHIssueComment> extractCommentInGithub(GHIssue ghIssue) throws IOException {
    return ghIssue.getComments();
  }


  private List<GHIssue> getGhIssuesList() throws IOException {
    return getGhRepository().getIssues(GHIssueState.ALL).subList(7,11);
  }

  private GHRepository getGhRepository() throws IOException {
    return getGithub().getRepository(STUDY_URL);
  }

  private GitHub getGithub() throws IOException {
    return new GitHubBuilder().withOAuthToken(ACCESS_TOKEN_FOR_GITHUB).build();
  }
  public StudyInfo transformToStudyInfo(GHIssue ghIssue) throws IOException {
    return StudyInfo.builder()
            .week(ghIssue.getNumber() + "")
            .title(ghIssue.getTitle())
            .learn(ghIssue.getBody().split("# [가-힣]+")[1].strip())
            .goal(ghIssue.getBody().split("# [가-힣\\s()]+")[2].strip())
            .participation(ghIssue.getCommentsCount())
            .createdAt(asLocalDateTime(ghIssue.getCreatedAt()))
            .updatedAt(asLocalDateTime(ghIssue.getUpdatedAt()))
            .build();
  }

  public StudyComment transformToCommentInfo(GHIssueComment ghIssueComment, StudyInfo studyInfo) {
//        return Comment.builder()
//                .
//                .studyInfo(studyInfo)
//                .build();

    return new StudyComment();
  }

}
