package whiteship.toyproject.livestudy.common.code;

import java.util.Arrays;

public enum Site {
  SITE_200001("NAVER"),
  SITE_200002("TISTORY"),
  SITE_200003("GITHUB"),
  SITE_200004("NOTION"),
  SITE_200005("VELOG"),
  SITE_200006("OTHER"),
  ;

  private final String value;

  private Site(String value) {
    this.value = value;
  }

  public static String getValue(String code) {
    return Arrays.stream(values()).filter(i -> code.equals(i.name())).findFirst()
        .orElse(SITE_200006).getValue();
  }

  public static String findByValue(String arg) {
    for (Site site : values()) {
      if (arg.equals(site.getValue()) || arg.contains(site.getValue().toLowerCase())) {
        return site.name();
      }
    }
    return "";
  }

  public String getValue() {
    return value;
  }


}
