package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
