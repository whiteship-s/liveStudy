package whiteship.toyproject.livestudy.common.code;

public enum EmojiEnum {
    EMOJI_300001("HEART"),
    EMOJI_300002("PLUS_ONE")
    ;

    private final String value;
    private EmojiEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String findByValue(String arg) {
        for (EmojiEnum emoji : values()) {
            if (arg.equals(emoji.getValue())) {
                return emoji.name();
            }
        }
        return "";
    }

}
