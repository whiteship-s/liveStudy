package whiteship.toyproject.livestudy.common.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import whiteship.toyproject.livestudy.common.code.Site;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter @Getter @Builder
@NoArgsConstructor
@Entity
@Table(name = "T_STUDY_COMMENT_SITE")
public class StudyCommentSite {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long siteSeq;

  private Integer siteOrder;
  @ManyToOne
  @JoinColumn(name = "COMMENT_SEQ", referencedColumnName = "COMMENT_SEQ")
  private StudyComment studyComment;
  private String siteCode;
  @Column( length = 100000 )
  private String site;

  public StudyCommentSite(Long siteSeq, Integer siteOrder, StudyComment studyComment, String siteCode, String site) {
    this.siteSeq = siteSeq;
    this.siteOrder = siteOrder;
    this.studyComment = studyComment;
    this.siteCode = siteCode;
    this.site = site;
  }

  public static StudyCommentSite transformToStudyCommentSite(StudyComment studyComment, String url, int siteOrder) {
    return StudyCommentSite
            .builder()
            .siteOrder(siteOrder)
            .studyComment(studyComment)
            .siteCode(Site.findByValue(url))
            .site(url)
            .build();
  }

  public static List<StudyCommentSite> getStudyCommentSites(StudyComment studyComment, String body) {
    List<StudyCommentSite> studyCommentSiteList = new ArrayList<>();
    String REGEX = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(body);

    AtomicInteger index = new AtomicInteger(1);

    matcher.results()
            .map(result -> transformToStudyCommentSite(studyComment, result.group(), index.getAndIncrement()))
            .forEach(studyCommentSiteList::add);

    return studyCommentSiteList;
  }
}
