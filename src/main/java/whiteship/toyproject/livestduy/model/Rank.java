package whiteship.toyproject.livestduy.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Rank {
  @Id @GeneratedValue
  private Long id;
  private String rankCol;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
