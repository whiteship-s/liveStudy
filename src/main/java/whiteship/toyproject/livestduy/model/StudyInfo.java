package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import whiteship.toyproject.livestduy.access.StudyInfoDto;

@Entity
@Setter
@Getter
public class StudyInfo {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String title;
  private int week;
  private int participation;
  private String learn;
  private String goal;

  public StudyInfo(StudyInfoDto studyInfoDto) {
    this.title = studyInfoDto.getTitle();
    this.week = studyInfoDto.getWeek();
    this.participation = studyInfoDto.getParticipation();
    this.learn = studyInfoDto.getLearn();
    this.goal = studyInfoDto.getGoal();
  }
}
