package whiteship.toyproject.livestudy.github.api;


import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

import java.io.IOException;
import java.util.*;

@Component
public class GithubApi {


  @Value("${github.token}")
  private String ACCESS_TOKEN_FOR_GITHUB;

  private static final String STUDY_URL = "whiteship/live-study";


  public List<GHIssue> extractStudyInfoInGithub() throws IOException {
    return getGhIssuesList();
  }

  private List<GHIssue> getGhIssuesList() throws IOException {
//    return getGhRepository().getIssues(GHIssueState.ALL).subList(0, 9);
    return getGhRepository().getIssues(GHIssueState.ALL);
  }

  private GHRepository getGhRepository() throws IOException {
    return getGithub().getRepository(STUDY_URL);
  }

  private GitHub getGithub() throws IOException {
    return new GitHubBuilder().withOAuthToken(ACCESS_TOKEN_FOR_GITHUB).build();
  }


  public boolean validCheckIsStudy(GHIssue ghIssue) throws IOException {
    return ghIssue.getLabels().stream().anyMatch(ghLabel -> ghLabel.getName().equals("과제"));
  }

  public String[] validCheckHaveStudyWork(GHIssue ghIssue) {
    return ghIssue.getBody().split("# 과제");
  }

  public String[] splitStudyWorkList(GHIssue ghIssue) {
    return ghIssue.getBody().split("# 과제 [0-9].");
  }

}
