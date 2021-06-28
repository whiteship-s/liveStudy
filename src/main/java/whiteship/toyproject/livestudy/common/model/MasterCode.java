package whiteship.toyproject.livestudy.common.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "T_MASTER_CODE")
public class MasterCode {

  @Id
  private String masterCode;
  private String masterDesc;
}
