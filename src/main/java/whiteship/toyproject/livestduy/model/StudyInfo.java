package whiteship.toyproject.livestduy.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.IOException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.kohsuke.github.GHIssue;


@Table(name = "studyInfo")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private int week;
    private int participation;
    private String learn;
    private String goal;

    @Builder
    public StudyInfo(String title, int week, int participation, String learn, String goal) {
        this.title = title;
        this.week = week;
        this.participation = participation;
        this.learn = learn;
        this.goal = goal;
    }

    public static StudyInfo createStudyInfo(GHIssue issue) throws IOException {
        return StudyInfo.builder()
            .title(issue.getTitle())
            .week(issue.getNumber())
            .participation(issue.getComments().size())
            .learn(issue.getBody().split("# [가-힣]+")[1].strip())
            .goal(issue.getBody().split("# [가-힣\\s()]+")[2].strip())
            .build();
    }
}
