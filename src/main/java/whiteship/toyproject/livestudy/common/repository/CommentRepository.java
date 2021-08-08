package whiteship.toyproject.livestudy.common.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whiteship.toyproject.livestudy.common.model.StudyComment;

public interface CommentRepository extends JpaRepository<StudyComment, Long> {

  List<StudyComment> findAllByStudyCode(String StudyCode);
}
