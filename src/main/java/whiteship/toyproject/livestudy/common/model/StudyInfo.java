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
  private String studyTopic;
  private LocalDateTime studyDeadline;
  private boolean studyWorkYn;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private String studyStatus;

  public StudyInfo(Long studySeq, String studyCode, String studyGoal, String studyTopic, LocalDateTime studyDeadline, boolean studyWorkYn, LocalDateTime createdAt, LocalDateTime updatedAt, String studyStatus) {
    this.studySeq = studySeq;
    this.studyCode = studyCode;
    this.studyGoal = studyGoal;
    this.studyTopic = studyTopic;
    this.studyDeadline = studyDeadline;
    this.studyWorkYn = studyWorkYn;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.studyStatus = studyStatus;
  }
}
