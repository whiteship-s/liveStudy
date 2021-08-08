package whiteship.toyproject.livestudy.site.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

@Data
public class StudyInfoDto {
  private Integer season;
  private Integer week;
  private String studyGoal;
  private String studyTopic;
  private LocalDateTime studyDeadline;
  private boolean studyWorkYn;
  private List<CommentDto> comments;
  private Long emojiCount;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String studyStatus;

  public StudyInfoDto(StudyInfo studyInfo) {
    this.season = 1;
    this.week = Study.convertStudyCodeIntoWeek(studyInfo.getStudyCode());
    this.studyGoal = studyInfo.getStudyGoal();
    this.studyTopic = studyInfo.getStudyTopic();
    this.studyDeadline = studyInfo.getStudyDeadline();
    this.studyWorkYn = studyInfo.isStudyWorkYn();
    this.createdAt = studyInfo.getCreatedAt();
    this.updatedAt = studyInfo.getUpdatedAt();
    this.studyStatus = studyInfo.getStudyStatus();
  }
}
