package whiteship.toyproject.livestduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestduy.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
