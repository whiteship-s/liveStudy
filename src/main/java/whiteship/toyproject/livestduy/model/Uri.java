package whiteship.toyproject.livestduy.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import whiteship.toyproject.livestduy.access.UriDto;

@Entity
@Setter
@Getter
public class Uri {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private BlogType blogType;
  private String url;

  @ManyToOne
  @JoinColumn(name = "COMMENT_ID")
  private Comment comment;

  public Uri(UriDto uriDto) {
    this.blogType = uriDto.getBlogType();
    this.url = uriDto.getUrl();
    this.comment = uriDto.getComment();
  }
}
