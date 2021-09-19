package whiteship.toyproject.livestudy.site.cotroller;

import java.util.stream.Collectors;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whiteship.toyproject.livestudy.site.dto.CommentDto;
import whiteship.toyproject.livestudy.site.dto.StudyInfoDto;
import whiteship.toyproject.livestudy.site.service.CommentService1;
import whiteship.toyproject.livestudy.site.service.StudyInfoService1;

@RestController
@RequestMapping("/v1")
public class StudyInfoController1 {

  private final StudyInfoService1 studyInfoService1;
  private final CommentService1 commentService1;

  public StudyInfoController1(
      StudyInfoService1 studyInfoService1, CommentService1 commentService1) {
    this.studyInfoService1 = studyInfoService1;
    this.commentService1 = commentService1;
  }


  public StudyInfoDto clear(@PathVariable Integer week) throws NotFoundException {
    StudyInfoDto studyInfo = new StudyInfoDto(studyInfoService1.selectIssue(week));
    studyInfo.setComments(commentService1.selectComments(week).stream().map(CommentDto::new)
        .collect(Collectors.toList()));
    studyInfo.setEmojiCount(studyInfoService1.countEmoji(week));
    return studyInfo;
  }

}
