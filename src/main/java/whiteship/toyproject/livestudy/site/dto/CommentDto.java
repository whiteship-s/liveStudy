package whiteship.toyproject.livestudy.site.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import whiteship.toyproject.livestudy.common.model.StudyComment;

@Data
public class CommentDto {
  private String content;
  private boolean whiteshipFeedbackYn;
  private String feedbackContent;
  private String writeId;
  private List<CommentSiteDto> sites;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  private LocalDateTime feedbackRegDate;
  private boolean status;


  public CommentDto(StudyComment studyComment) {
    this.regDate = studyComment.getRegDate();
    this.modDate = studyComment.getModDate();
    this.content = studyComment.getContent();
    this.writeId = studyComment.getUserInfo().getGithubId();
    this.sites = studyComment.getCommentSites().stream().map(CommentSiteDto::new)
        .collect(Collectors.toList());
    this.whiteshipFeedbackYn = studyComment.isWhiteshipFeedbackYn();
    this.feedbackContent = studyComment.getFeedbackContent();
    this.feedbackRegDate = studyComment.getFeedbackRegDate();
    this.status = studyComment.isStatus();
  }
}
