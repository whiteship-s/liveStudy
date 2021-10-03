package whiteship.toyproject.livestudy.site.cotroller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whiteship.toyproject.livestudy.site.dto.UserDto;
import whiteship.toyproject.livestudy.site.service.CommentService;

@RestController
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {

// 1. 전체 주제 목록
// 2. 주제에 따른 유저 목록

  private final CommentService commentService;

  public void getCommentList() {

  }


  @GetMapping("/user/{week}")
  public List<UserDto> getUserListBySubject(@PathVariable Integer week) {
    return commentService.getUserListBySubject(week)
        .stream().map(UserDto::new)
        .collect(Collectors.toList());
  }


}
