package whiteship.toyproject.livestduy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHIssueState;
import org.kohsuke.github.GHReaction;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.ReactionContent;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestduy.model.StudyInfo;
import whiteship.toyproject.livestduy.repository.CommentRepository;
import whiteship.toyproject.livestduy.repository.StudyInfoRepository;
import whiteship.toyproject.livestduy.model.BlogType;
import whiteship.toyproject.livestduy.model.Comment;

/**
 * API 문서 : https://docs.github.com/en/rest/reference/reactions#list-reactions-for-an-issue-comment
 * https://api.github.com/repos/whiteship/live-study https://api.github.com/repos/whiteship/live-study/issues/1
 * https://api.github.com/repos/whiteship/live-study/issues/1/comments header : Accept :
 * application/vnd.github.squirrel-girl-preview+jso https://api.github.com/repos/whiteship/live-study/issues/1/reactions
 */
@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {

    //personal token need to secret
    private static final String MY_PERSONAL_TOKEN = "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";
    private final StudyInfoRepository studyInfoRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        GitHub github = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();

        //Repository 연결
        GHRepository repo = github.getRepository("whiteship/live-study");

        //IssueState ALL, OPEN, CLOSED
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);

        for (int i = 4; i <= 4; i++) {
            GHIssue issue = repo.getIssue(i);
            StudyInfo studyInfo = StudyInfo.createStudyInfo(issue);
            StudyInfo newStudyInfo = studyInfoRepository.save(studyInfo);

            for (GHIssueComment comments : issue.getComments()) {
                Comment comment = Comment.createComment(comments, newStudyInfo);
                commentRepository.save(comment);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //참여율 출력
//		for(String name : participant.keySet()){
//			double rate = (double)(participant.get(name) * 100) / issues.size();
//			bw.write("name : " + name);
//			bw.write(", Participation Rate : "+String.format("%.2f",rate)+"%");
//			bw.newLine();
//		}
        bw.close();
    }


}

