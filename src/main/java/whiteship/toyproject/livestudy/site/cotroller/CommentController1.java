package whiteship.toyproject.livestudy.site.cotroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whiteship.toyproject.livestudy.site.dto.CommentDto;
import whiteship.toyproject.livestudy.site.service.CommentService1;

@RestController
@RequestMapping("/v1")
public class CommentController1 {

  private final CommentService1 commentService1;

  public CommentController1(CommentService1 commentService1) {
    this.commentService1 = commentService1;
  }


  public List<CommentDto> clear(@PathVariable Integer week) {
    return commentService1.selectComments(week)
        .stream().map(CommentDto::new).collect(Collectors.toList());
  }
}