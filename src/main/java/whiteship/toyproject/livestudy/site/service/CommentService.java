package whiteship.toyproject.livestudy.site.service;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import whiteship.toyproject.livestudy.common.model.StudyComment;

public interface CommentService {
  List<StudyComment> selectComments(Integer week);
}
