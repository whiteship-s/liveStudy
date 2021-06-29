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
@Table(name = "T_STUDY_WORK")
public class StudyWork {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studyWorkSeq;
  @ManyToOne
  @JoinColumn(name = "STUDY_SEQ")
  private StudyInfo studyInfo;
  private Integer studyWorkOrder;
  private String studyWorkTitle;
  private String studyWorkContent;
  private boolean status;
}
