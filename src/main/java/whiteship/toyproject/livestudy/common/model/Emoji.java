package whiteship.toyproject.livestudy.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "T_STUDY_COMMENT_EMOJI")
public class Emoji {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long emojiIdx;
  @ManyToOne
  @JoinColumn(name = "COMMENT_SEQ")
  private StudyComment studyComment;
  private String emojiCode;
  private String emojiSelectGithubId;
}
