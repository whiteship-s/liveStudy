package whiteship.toyproject.livestduy.controller;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHReaction;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.ReactionContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestduy.model.Comment;
import whiteship.toyproject.livestduy.model.StudyInfo;
import whiteship.toyproject.livestduy.repository.CommentRepository;
import whiteship.toyproject.livestduy.repository.StudyInfoRepository;

@Component
public class InputDataBase implements ApplicationRunner {

  private static final String MY_PERSONAL_TOKEN = "3a1ecb4bb6720392aa51cfd20a0bbec4f1fabbe3";
  @Autowired
  private StudyInfoRepository studyInfoRepository;
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    GitHub github = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();

    //Repository 연결
    GHRepository repository = github.getRepository("whiteship/live-study");

    // 주차별로 db에 저장
    for (int i = 12; i <= 15; i++) {
      GHIssue issue = repository.getIssue(i);
      StudyInfo studyInfo = new StudyInfo();
      studyInfo.setTitle(issue.getTitle());
      studyInfo.setWeek(issue.getNumber());
      studyInfo.setLearn(issue.getBody().split("# [가-힣]+")[1].strip());
      studyInfo.setGoal(issue.getBody().split("# [가-힣\\s()]+")[2].strip());
      List<GHIssueComment> comments = issue.getComments();
      studyInfo.setParticipation(comments.size());
      StudyInfo info = studyInfoRepository.save(studyInfo);
//      studyInfoRepository.flush();

      for (GHIssueComment comment : comments) {
        Comment userComment = new Comment();
        String[] body = comment.getBody().split("\r|(\r\n)+|\n|(\n\r)");
        StringBuilder content = new StringBuilder();
        StringBuilder url = new StringBuilder();
        for (String s : body) {
          if (s.contains("http")) {
            String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(s);
            if (m.find()) {
              url.append(m.group().strip());
            }
            continue;
          }
          if (s.contains("(whiteship)")) {
            userComment.setLeaderComment(s.substring(("whiteship) ".length())).strip());
            continue;
          }
          content.append(s);
        }
        userComment.setUrl(url.toString());
        String strip = content.toString().strip();
        if (strip.contains("(whitehsip)")) {
          String[] split = strip.split("whitehsip");
          userComment.setUserComment(split[0].substring(1, split[0].length() - 1).strip());
          userComment.setLeaderComment(split[1].substring(1).strip());
        } else {
          userComment.setUserComment(strip);
        }
        userComment.setNickname(comment.getUser().getLogin());

        userComment.setCreateAt(comment.getCreatedAt());
        userComment.setUpdateAt(comment.getUpdatedAt());
        List<GHReaction> ghReactions = comment.listReactions().toList();
        userComment.setEmojiNum(ghReactions.size());
        for (GHReaction ghReaction : ghReactions) {
          userComment.setHeartFlag(ghReaction.getContent() == ReactionContent.HEART);
        }
        userComment.setStudyInfo(info);
        commentRepository.save(userComment);
        commentRepository.flush();
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    bw.close();


  }
}
