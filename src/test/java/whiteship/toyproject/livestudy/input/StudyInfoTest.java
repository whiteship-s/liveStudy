package whiteship.toyproject.livestudy.input;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class StudyInfoTest {

  private static final String MY_PERSONAL_TOKEN = "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";
  GHRepository repository;

  @BeforeEach
  void setUp() throws IOException {
    GitHub github = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();
    repository = github.getRepository("whiteship/live-study");
  }

  @Test
  void issueLengthTest() throws IOException {
    GHIssue issue = repository.getIssue(10);
    String[] strings = issue.getBody().split("\n\r");
    assertThat(strings.length).isEqualTo(3);
  }
}
