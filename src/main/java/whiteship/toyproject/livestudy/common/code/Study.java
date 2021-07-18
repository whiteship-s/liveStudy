package whiteship.toyproject.livestudy.common.code;

public enum Study {
    STUDY_110001("1"),
    STUDY_110002("2"),
    STUDY_110003("3"),
    STUDY_110004("4"),
    STUDY_110005("5"),
    STUDY_110006("6"),
    STUDY_110007("7"),
    STUDY_110008("8"),
    STUDY_110009("9"),
    STUDY_110010("10"),
    STUDY_110011("11"),
    STUDY_110012("12"),
    STUDY_110013("13"),
    STUDY_110014("14"),
    STUDY_110015("15"),
    ;

    private final String value;
    private Study(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String findByValue(String arg) {
        for (Study study : values()) {
            if (arg.equals(study.getValue())) {
                return study.name();
            }
        }
        return "";
    }
}
