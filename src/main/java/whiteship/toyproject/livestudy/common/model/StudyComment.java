package whiteship.toyproject.livestudy.common.model;

import static whiteship.toyproject.livestudy.common.library.DateFormat.asLocalDateTime;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHIssueComment;

@Setter
@Getter
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

  private LocalDateTime regDate;
  private LocalDateTime modDate;
  @Column(columnDefinition = "TEXT")
  private String content;

  @OneToMany(mappedBy = "studyComment")
  private List<StudyCommentSite> commentSites = new ArrayList<>();
  @OneToMany(mappedBy = "studyComment")
  private List<Emoji> emojis = new ArrayList<>();

  private boolean whiteshipFeedbackYn;
  @Column(columnDefinition = "TEXT")
  private String feedbackContent;
  private LocalDateTime feedbackRegDate;
  private boolean status;


  @Builder
  public StudyComment(Long commentSeq, String studyCode, UserInfo userInfo, LocalDateTime regDate,
      LocalDateTime modDate, String content, boolean whiteshipFeedbackYn, String feedbackContent,
      LocalDateTime feedbackRegDate, boolean status) {
    this.commentSeq = commentSeq;
    this.studyCode = studyCode;
    this.userInfo = userInfo;
    this.regDate = regDate;
    this.modDate = modDate;
    this.content = content;
    this.whiteshipFeedbackYn = whiteshipFeedbackYn;
    this.feedbackContent = feedbackContent;
    this.feedbackRegDate = feedbackRegDate;
    this.status = status;
  }

  public static StudyComment transformToStudyComment(GHIssueComment comment, StudyInfo studyInfo,
      UserInfo userInfo) throws IOException {
//    feedback Yn
    boolean whiteshipFeedbackYn = false;
    String feedbackContent = null;
    LocalDateTime feedbackRegDate = null;
    String content = comment.getBody();

    if (comment.getBody().contains("(whiteship)")) {
      String[] getFeedBack = comment.getBody().split("\\(whiteship\\)");
      whiteshipFeedbackYn = true;
      content = getFeedBack[0];
      feedbackContent = getFeedBack[1];
      feedbackRegDate = asLocalDateTime(comment.getUpdatedAt());
    }

    return StudyComment.builder()
        .studyCode(studyInfo.getStudyCode())
        .userInfo(userInfo)
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
