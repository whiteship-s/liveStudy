package whiteship.toyproject.livestudy.site.dto;

import lombok.Data;
import whiteship.toyproject.livestudy.common.model.Emoji;

@Data
public class CommentEmojiDto {
  private String emojiCode;
  private String emojiSelectGithubId;
  private boolean emojiSelectYn;

  public CommentEmojiDto(Emoji emoji) {
    this.emojiCode = emoji.getEmojiCode();
    this.emojiSelectGithubId = emoji.getEmojiSelectGithubId();
    this.emojiSelectYn = emoji.isEmojiSelectYn();
  }
}
