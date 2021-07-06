package whiteship.toyproject.livestudy.common.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @Builder
@NoArgsConstructor
@Entity
@Table(name = "T_STUDY_INFO")
public class StudyInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studySeq;
  @Column(name = "STUDY_CODE")
  private String studyCode;
  private String studyGoal;
  private LocalDateTime studyDeadline;
  private boolean studyWorkYn;
}
