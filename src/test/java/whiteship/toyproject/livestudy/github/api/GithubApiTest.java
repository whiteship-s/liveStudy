package whiteship.toyproject.livestudy.github.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GithubApiTest {
    @Autowired
    GithubApi githubApi;

    @Test
    void extractingData() throws IOException {
        List<GHIssue> ghIssues = githubApi.extractStudyInfoInGithub();
        assertNotNull(ghIssues);

    }



}