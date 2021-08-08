package whiteship.toyproject.livestudy.site.cotroller;

import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whiteship.toyproject.livestudy.site.dto.CommentDto;
import whiteship.toyproject.livestudy.site.dto.StudyInfoDto;
import whiteship.toyproject.livestudy.site.service.CommentService;
import whiteship.toyproject.livestudy.site.service.StudyInfoService;

@RestController
@RequestMapping("/v1")
public class StudyInfoController {

  private final StudyInfoService studyInfoService;
  private final CommentService commentService;

  public StudyInfoController(
      StudyInfoService studyInfoService, CommentService commentService) {
    this.studyInfoService = studyInfoService;
    this.commentService = commentService;
  }

  @GetMapping("/issue/{week}")
  public StudyInfoDto getIssue(@PathVariable Integer week) throws NotFoundException {
    StudyInfoDto studyInfo = new StudyInfoDto(studyInfoService.selectIssue(week));
    studyInfo.setComments(commentService.selectComments(week).stream().map(CommentDto::new)
        .collect(Collectors.toList()));
    studyInfo.setEmojiCount(studyInfoService.countEmoji(week));
    return studyInfo;
  }

}
