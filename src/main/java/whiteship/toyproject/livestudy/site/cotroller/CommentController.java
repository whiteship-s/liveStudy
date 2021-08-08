package whiteship.toyproject.livestudy.site.cotroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whiteship.toyproject.livestudy.site.dto.CommentDto;
import whiteship.toyproject.livestudy.site.service.CommentService;

@RestController
@RequestMapping("/v1")
public class CommentController {

  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/comment/{week}")
  public List<CommentDto> getComments(@PathVariable Integer week) {
    return commentService.selectComments(week)
        .stream().map(CommentDto::new).collect(Collectors.toList());
  }
}
