package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHReaction;
import org.kohsuke.github.ReactionContent;

@Table(name = "comment")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nickname;
    @Column(length = 3000)
    private String url;
    private String leaderComment;
    @Column(length = 3000)
    private String userComment;
    private Integer emojiNum;
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean heartFlag;
    @Enumerated(EnumType.STRING)
    private BlogType blogType;
    @ManyToOne
    @JoinColumn(name = "STUDY_INFO_ID")
    private StudyInfo studyInfo;

    @Builder
    public Comment(String nickname, String url, String leaderComment, String userComment,
        Integer emojiNum, boolean heartFlag, BlogType blogType,
        StudyInfo studyInfo) {
        this.nickname = nickname;
        this.url = url;
        this.leaderComment = leaderComment;
        this.userComment = userComment;
        this.emojiNum = emojiNum;
        this.heartFlag = heartFlag;
        this.blogType = blogType;
        this.studyInfo = studyInfo;
    }

    public static Comment createComment(GHIssueComment comment, final StudyInfo studyInfo)
        throws IOException {
        System.out.println("처음이다");
        String url = "";
        StringBuffer content = new StringBuffer();
        String leaderComment = "";
        String userComment = "";
        Integer emojiNum = 0;
        Boolean heartFlag = false;

        String[] bodyArr = getBody(comment);
        System.out.println(bodyArr.length);

        for (String body : bodyArr) {
            System.out.println("body : " + body + " @@");
            Map<String, String> map = getUrl(body);
            url = map.get("url");
            leaderComment = map.get("leaderComment");
            if ("pass".equals(map.get("flag"))) {
                break;
            }
            content.append(body);
        }

        String body = content.toString().strip();
        if (body.contains("(whiteship)")) {
            Map<String, String> mapComment = getComment(body);
            leaderComment = mapComment.get("leaderComment");
            userComment = mapComment.get("userComment");
        } else {
            userComment = body.strip();
        }

        BlogType blogType = getBlogType(url);
        Map<String, Object> emoji = getEmoji(comment);
        emojiNum = (Integer) emoji.get("emojiNum");
        heartFlag = (Boolean) emoji.get("heartFlag");

        return Comment.builder()
            .nickname(comment.getUser().getLogin())
            .url(url)
            .leaderComment(leaderComment)
            .userComment(userComment)
            .emojiNum(emojiNum)
            .heartFlag(heartFlag)
            .blogType(blogType)
            .studyInfo(studyInfo)
            .build();
    }

    private static String[] getBody(GHIssueComment comment) {
        System.out.println("body진짜 : " + comment.getBody());
        return comment.getBody().split("\r|(\r\n)+|\n|(\n\r)");
    }

    private static Map<String, String> getUrl(final String body) {
        Map<String, String> map = new HashMap<>();
        String url = "";

        if (body.contains("http")) {
            String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(body);
            if (matcher.find()) {
                url = matcher.group().strip();
                map.put("url", url);
                map.put("flag", "pass");
                return map;
                //System.out.println(url.toString());
                //String[] https = url.toString().split("https");
                //System.out.println(https.length);

//                Arrays.stream(https)
//                    .filter(v -> !v.equals(""))
//                    .forEach(v ->
//                        System.out.println(v)
//                    );
            }
        }

        if (body.contains("(whiteship)")) {
            map.put("leaderComment", body.substring(("whiteship) ".length())).strip());
            return map;
        }

        return map;
    }

    private static BlogType getBlogType(final String url) {
        return BlogType.judgeBlog(url);
    }

    private static Map<String, String> getComment(final String body) {
        Map<String, String> commentMap = new HashMap<>();
        String[] split = body.split("whitehsip");
        commentMap.put("userComment", split[0].substring(1, split[0].length() - 1).strip());
        commentMap.put("leaderComment", split[1].substring(1).strip());
        return commentMap;
    }

    private static Map<String, Object> getEmoji(final GHIssueComment comment) throws IOException {
        Map<String, Object> emojiMap = new HashMap<>();
        List<GHReaction> ghReactions = comment.listReactions().toList();
        emojiMap.put("emojiNum", ghReactions.size());
        for (GHReaction ghReaction : ghReactions) {
            emojiMap.put("heartFlag", ghReaction.getContent() == ReactionContent.HEART);
        }
        return emojiMap;
    }

    @Converter
    private static class BooleanToYNConverter implements AttributeConverter<Boolean, String> {

        @Override
        public String convertToDatabaseColumn(Boolean attribute) {
            return (attribute != null && attribute) ? "Y" : "N";
        }

        @Override
        public Boolean convertToEntityAttribute(String dbData) {
            return "Y".equals(dbData);
        }
    }


}