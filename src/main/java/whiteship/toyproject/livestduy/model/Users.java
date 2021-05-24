package whiteship.toyproject.livestduy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Users {
  @Id @GeneratedValue
  private Long id;
  private String nickname;
  private String uri;
  private String blogType;
}
