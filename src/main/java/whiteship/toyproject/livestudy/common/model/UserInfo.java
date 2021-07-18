package whiteship.toyproject.livestudy.common.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kohsuke.github.GHUser;

import java.io.IOException;

@Setter @Getter @Builder
@NoArgsConstructor
@Entity
@Table(name = "T_USER_INFO")
public class UserInfo {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long UserSeq;

  @Id
  @Column(name = "GITHUB_ID")
  private String githubId;
  private String githubNickname;
  private String githubProfileImg;
  private boolean status;

  public UserInfo(String githubId, String githubNickname, String githubProfileImg, boolean status) {
//    UserSeq = userSeq;
    this.githubId = githubId;
    this.githubNickname = githubNickname;
    this.githubProfileImg = githubProfileImg;
    this.status = status;
  }

  public static UserInfo transformToUserInfo(GHUser user) throws IOException {

    return UserInfo.builder()
            .githubId(user.getLogin())
            .githubNickname(user.getName())
            .githubProfileImg(user.getHtmlUrl()+"")
            .status(true)
            .build();
  }
}
