package whiteship.toyproject.livestudy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.model.StudyCommentSite;

public interface StudyCommentSiteRepository extends JpaRepository<StudyCommentSite, Integer> {

}
