package whiteship.toyproject.livestduy.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import whiteship.toyproject.livestduy.model.BlogType;
import whiteship.toyproject.livestduy.model.Comment;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class UriDto {

  private String url;
  private BlogType blogType;
  private Comment comment;
}
