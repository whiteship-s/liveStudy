package whiteship.toyproject.livestduy.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Comment {

  @Id
  @GeneratedValue
  private Long id;
  private Integer emojiNum;
  private String content;
  private boolean heartFlag;
  private String leaderComment;
  @ManyToOne
  @JoinColumn(name = "USERS_ID")

  private Users users;
  @ManyToOne
  @JoinColumn(name = "STUDY_INFO_ID")
  private StudyInfo studyInfo;
  private String blogType;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
}
