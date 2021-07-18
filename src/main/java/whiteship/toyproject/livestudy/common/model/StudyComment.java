package whiteship.toyproject.livestudy.common.model;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHIssueComment;

import static whiteship.toyproject.livestudy.common.library.DateFormat.asLocalDateTime;

@Setter @Getter @Builder
@NoArgsConstructor
@Entity
@Table(name = "T_STUDY_COMMENT")
public class StudyComment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "COMMENT_SEQ")
  private Long commentSeq;
  private String studyCode;
  @ManyToOne
  @JoinColumn(name = "GITHUB_ID")
  private UserInfo userInfo;
  @OneToOne
  @JoinColumn(referencedColumnName = "STUDY_CODE")
  private StudyInfo studyInfo;
  private LocalDateTime regDate;
  private LocalDateTime modDate;
  @Column(columnDefinition = "TEXT")
  private String content;
  private boolean whiteshipFeedbackYn;
  @Column(columnDefinition = "TEXT")
  private String feedbackContent;
  private LocalDateTime feedbackRegDate;
  private boolean status;


  public StudyComment(Long commentSeq, String studyCode, UserInfo userInfo, StudyInfo studyInfo, LocalDateTime regDate, LocalDateTime modDate, String content, boolean whiteshipFeedbackYn, String feedbackContent, LocalDateTime feedbackRegDate, boolean status) {
    this.commentSeq = commentSeq;
    this.studyCode = studyCode;
    this.userInfo = userInfo;
    this.studyInfo = studyInfo;
    this.regDate = regDate;
    this.modDate = modDate;
    this.content = content;
    this.whiteshipFeedbackYn = whiteshipFeedbackYn;
    this.feedbackContent = feedbackContent;
    this.feedbackRegDate = feedbackRegDate;
    this.status = status;
  }

  public static StudyComment transformToStudyComment(GHIssueComment comment, StudyInfo studyInfo, UserInfo userInfo) throws IOException {
//    feedback Yn
    boolean whiteshipFeedbackYn = false;
    String feedbackContent = null;
    LocalDateTime feedbackRegDate = null;
    String content = comment.getBody();

    if(comment.getBody().contains("(whiteship)")) {
      String[] getFeedBack = comment.getBody().split("\\(whiteship\\)");
      whiteshipFeedbackYn = true;
      content = getFeedBack[0];
      feedbackContent = getFeedBack[1];
      feedbackRegDate = asLocalDateTime(comment.getUpdatedAt());
    }


    return StudyComment.builder()
            .studyCode(studyInfo.getStudyCode())
            .userInfo(userInfo)
            .studyInfo(studyInfo)
            .regDate(asLocalDateTime(comment.getCreatedAt()))
            .modDate(asLocalDateTime(comment.getUpdatedAt()))
            .content(content)
            .whiteshipFeedbackYn(whiteshipFeedbackYn)
            .feedbackContent(feedbackContent)
            .feedbackRegDate(feedbackRegDate)
            .status(true)
            .build();
  }

}
