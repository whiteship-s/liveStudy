package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Setter
@Getter
public class Comment {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String nickname;
  private String url;
  private String leaderComment;
  private String userComment;
  private Integer emojiNum;
  private boolean heartFlag;

  @ManyToOne
  @JoinColumn(name = "STUDY_INFO_ID")
  private StudyInfo studyInfo;
  private Date createAt;
  private Date updateAt;
}
