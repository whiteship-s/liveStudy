package whiteship.toyproject.livestduy.model;

import java.util.Arrays;

public enum BlogType {
  TISTORY,
  NOTION,
  GITHUB,
  NAVER,
  VELOG,
  BRUNCH,
  MEDIUM,
  OTHER;


  public static BlogType find(String url) {
    return Arrays.stream(values()).filter(t -> url.contains(t.name().toLowerCase())).findFirst()
        .orElse(OTHER);
  }
}
