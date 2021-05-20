package whiteship.toyproject.livestduy.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Comment {
  @Id @GeneratedValue
  private Long id;
  private Integer emojiNum;
  private String content;
  private boolean heartFlag;
  private String leaderComment;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
  private Long userId;
  private Long studyInfoId;
}
