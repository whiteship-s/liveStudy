package whiteship.toyproject.livestduy.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Table(name = "rank")
@Entity
@Setter @Getter
public class Rank extends BaseTimeEntity {
  @Id @GeneratedValue
  private Long id;
  private String rankCol;
}
