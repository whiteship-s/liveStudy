package whiteship.toyproject.livestudy.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHReaction;
import whiteship.toyproject.livestudy.common.code.EmojiEnum;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @Builder
@NoArgsConstructor
@Entity
@Table(name = "T_STUDY_COMMENT_EMOJI")
public class Emoji {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long emojiSeq;
  @ManyToOne
  @JoinColumn(name = "COMMENT_SEQ", referencedColumnName = "COMMENT_SEQ")
  private StudyComment studyComment;

  private String emojiCode;
  private String emojiSelectGithubId;
  private boolean emojiSelectYn;


  public Emoji(Long emojiSeq, StudyComment studyComment, String emojiCode, String emojiSelectGithubId, boolean emojiSelectYn) {
    this.emojiSeq = emojiSeq;
    this.studyComment = studyComment;
    this.emojiCode = emojiCode;
    this.emojiSelectGithubId = emojiSelectGithubId;
    this.emojiSelectYn = emojiSelectYn;
  }

  public static Emoji transformToEmoji(GHReaction ghReaction, StudyComment studyComment) {
    return Emoji
            .builder()
            .studyComment(studyComment)
            .emojiCode(EmojiEnum.findByValue(ghReaction.getContent().name()))
            .emojiSelectGithubId(ghReaction.getUser().getLogin())
            .emojiSelectYn(true)
            .build();
  }

    public static List<Emoji> getEmojis(StudyComment studyComment, GHIssueComment comment) {
      List<Emoji> emojiList = new ArrayList<>();
      comment.listReactions()
              .forEach(ghReaction -> emojiList.add(transformToEmoji(ghReaction, studyComment)));
      return emojiList;
    }
}
