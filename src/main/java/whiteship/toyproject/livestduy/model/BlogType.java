package whiteship.toyproject.livestduy.model;

import lombok.Getter;

@Getter
public enum BlogType {
    TISTORY("tistory"),
    GITHUB("github"),
    NOTION("notion"),
    VELOG("velog"),
    NAVER("naver"),
    GUITAR("guitar");

    private String blog;

    BlogType(String blog) {
        this.blog = blog;
    }

    public static BlogType judgeBlog(final String url) {
        BlogType blogType = null;
        BlogType[] values = BlogType.values();
        for (BlogType type : BlogType.values()) {
            if (url.contains(type.getBlog())) {
                return type;
            }
        }
        return GUITAR;
    }

}
