package whiteship.toyproject.livestudy.common.code;

import java.util.Arrays;

public enum Study {
  STUDY_110001(1),
  STUDY_110002(2),
  STUDY_110003(3),
  STUDY_110004(4),
  STUDY_110005(5),
  STUDY_110006(6),
  STUDY_110007(7),
  STUDY_110008(8),
  STUDY_110009(9),
  STUDY_110010(10),
  STUDY_110011(11),
  STUDY_110012(12),
  STUDY_110013(13),
  STUDY_110014(14),
  STUDY_110015(15);

  private final Integer week;

  private Study(Integer week) {
    this.week = week;
  }

  public static Integer convertStudyCodeIntoWeek(String studyCode) {
    return Arrays.stream(values()).filter(study -> studyCode.equals(study.name())).findFirst()
        .orElseThrow().week;
  }

  public static String findByValue(Integer week) {
    return Arrays.stream(values()).filter(study -> study.week.equals(week)).findFirst()
        .orElseThrow()
        .name();

  }

  public Integer getWeek() {
    return week;
  }
}
