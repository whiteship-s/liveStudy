package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import whiteship.toyproject.livestduy.access.CommentWriteDto;

@Entity
@Setter
@Getter
public class Comment {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String nickname;
  private String url;
  private String leaderComment;
  private String userComment;
  private Integer emojiNum;
  private boolean heartFlag;

  @ManyToOne
  @JoinColumn(name = "STUDY_INFO_ID")
  private StudyInfo studyInfo;
  private Date createAt;
  private Date updateAt;

  public Comment(CommentWriteDto dto) {
    this.nickname = dto.getId();
    this.url = dto.getUrl();
    this.leaderComment = dto.getLeader();
    this.userComment = dto.getUser();
    this.emojiNum = dto.getEmojiCount();
    this.heartFlag = dto.isCheckHeart();
    this.studyInfo = dto.getStudyInfo();
    this.createAt = dto.getCreatedAt();
    this.updateAt = dto.getUpdatedAt();
  }
}
