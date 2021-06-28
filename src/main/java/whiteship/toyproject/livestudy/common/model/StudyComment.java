package whiteship.toyproject.livestudy.common.model;

import java.time.LocalDateTime;
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
@Table(name = "T_STUDY_COMMENT")
public class StudyComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long commentSeq;
  private String studyCode;
  @ManyToOne
  @JoinColumn(name = "REG_SEQ")
  private UserInfo userInfo;
  private LocalDateTime regDate;
  private String content;
  private boolean whiteshipFeedbackYn;
  private String feedbackContent;
  private LocalDateTime feedbackRegDate;
}
