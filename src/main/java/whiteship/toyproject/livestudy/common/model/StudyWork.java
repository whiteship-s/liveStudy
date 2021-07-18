package whiteship.toyproject.livestudy.common.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Arrays;


@Setter @Getter @Builder
@NoArgsConstructor
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
  @Column( length = 100000 )
  private String studyWorkContent;
  private boolean status;

  public StudyWork(Long studyWorkSeq, StudyInfo studyInfo, Integer studyWorkOrder, String studyWorkTitle, String studyWorkContent, boolean status) {
    this.studyWorkSeq = studyWorkSeq;
    this.studyInfo = studyInfo;
    this.studyWorkOrder = studyWorkOrder;
    this.studyWorkTitle = studyWorkTitle;
    this.studyWorkContent = studyWorkContent;
    this.status = status;
  }

  public static StudyWork transformToStudyWork(StudyInfo studyInfo, String studyWorkBody, int studyWorkOrder, int startIndex) {
    String[] studyWorkList = studyWorkBody.split("\\r\\n");
    return StudyWork.builder()
            .studyInfo(studyInfo)
            .studyWorkOrder(studyWorkOrder)
            .studyWorkTitle(studyWorkList[startIndex])
            .studyWorkContent(String.join("\r\n", Arrays.asList(studyWorkList).subList(startIndex+1, studyWorkList.length)))
            .status(true)
            .build();
  }
}
