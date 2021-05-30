package whiteship.toyproject.livestduy.access;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHReaction;
import whiteship.toyproject.livestduy.model.StudyInfo;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class CommentWriteDto {

  private String user;
  private String leader;
  private String url;
  private String id;
  private Date createdAt;
  private Date updatedAt;
  private Integer emojiCount;
  private StudyInfo studyInfo;
  private boolean checkHeart;
  private List<GHReaction> emojis;
}
