package whiteship.toyproject.livestudy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestudy.common.model.StudyComment;

public interface CommentRepository extends JpaRepository<StudyComment, Long> {

}
