package whiteship.toyproject.livestudy.site.dto;

import lombok.Data;
import whiteship.toyproject.livestudy.common.code.Site;
import whiteship.toyproject.livestudy.common.model.StudyCommentSite;

@Data
public class CommentSiteDto {

  private String domain;
  private String url;

  public CommentSiteDto(StudyCommentSite studyCommentSite) {
    this.domain = Site.getValue(studyCommentSite.getSiteCode());
    this.url = studyCommentSite.getSite();
  }
}
