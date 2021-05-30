package whiteship.toyproject.livestduy.access;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHReaction;
import org.kohsuke.github.ReactionContent;
import org.springframework.stereotype.Component;
import whiteship.toyproject.livestduy.model.StudyInfo;

@Component
public class CommentAccess {

  public CommentBodyDto rex(String[] body) {
    CommentBodyDto commentDto = new CommentBodyDto();
    StringBuilder content = new StringBuilder();
    for (String s : body) {
      if (s.contains("http")) {
        String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        if (m.find()) {
          commentDto.setUrl(m.group().strip());
        }
        continue;
      }
      if (s.contains("(whiteship)")) {
        commentDto.setLeader(s.substring(("whiteship) ".length())).strip());
        continue;
      }
      content.append(s);
    }
    commentDto.setContent(content.toString());
    return commentDto;
  }

  public CommentWriteDto save(GHIssueComment comment, StudyInfo info)
      throws IOException {
    String[] body = comment.getBody().split("\r|(\r\n)+|\n|(\n\r)");
    CommentWriteDto writeDto = CommentWriteDto.builder()
        .url(this.rex(body).getUrl())
        .id(comment.getUser().getLogin())
        .createdAt(comment.getCreatedAt())
        .updatedAt(comment.getUpdatedAt())
        .emojis(comment.listReactions().toList())
        .emojiCount(comment.listReactions().toList().size())
        .studyInfo(info)
        .build();

    for (GHReaction ghReaction : writeDto.getEmojis()) {
      writeDto.setCheckHeart(ghReaction.getContent() == ReactionContent.HEART);
    }
    if (this.rex(body).getContent().contains("(whiteship)")) {
      String[] split = this.rex(body).getContent().split("whiteship");
      writeDto.setUser(split[0].substring(1, split[0].length() - 1).strip());
      writeDto.setLeader(split[1].substring(1).strip());
    } else {
      writeDto.setUser(this.rex(body).getContent());
      writeDto.setLeader(this.rex(body).getLeader());
    }
    return writeDto;
  }
}
