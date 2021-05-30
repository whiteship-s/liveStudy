package whiteship.toyproject.livestduy.access;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHIssueComment;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter @Getter
public class StudyInfoDto {
  private Long id;
  private String title;
  private int week;
  private int participation;
  private String learn;
  private String goal;
  private List<GHIssueComment> comments;
}
