package whiteship.toyproject.livestudy.common.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "T_COMMON_CODE")
public class CommonCode {

  @Id
  private String code;
  @ManyToOne
  @JoinColumn(name = "MASTER_CODE")
  private MasterCode masterCode;
  private String codeKr;
  private String codeDesc;
  private Integer codeOrder;
  private String regId;
  private LocalDateTime reqDate;
  private String modId;
  private LocalDateTime modDate;
  private String modComment;
}
