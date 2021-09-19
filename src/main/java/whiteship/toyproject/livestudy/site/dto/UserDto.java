package whiteship.toyproject.livestudy.site.dto;

import lombok.Data;
import whiteship.toyproject.livestudy.common.model.UserInfo;

@Data
public class UserDto {

  private String id;
  private String name;

  public UserDto(UserInfo userInfo) {
    this.id = userInfo.getGithubId();
    this.name = userInfo.getGithubNickname();
  }
}
