package whiteship.toyproject.livestduy.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class StudyInfo {
  @Id @GeneratedValue
  private Long id;
  private String week;
  private String goal;
  private String learn;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
