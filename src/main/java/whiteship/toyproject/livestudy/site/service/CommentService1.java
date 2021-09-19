package whiteship.toyproject.livestudy.site.service;

import java.util.List;
import org.springframework.stereotype.Service;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.repository.CommentRepository;

@Service
public class CommentService1 {

  private final CommentRepository commentRepository;

  public CommentService1(
      CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<StudyComment> selectComments(Integer week) {
    return commentRepository.findAllByStudyCode(Study.findByValue(week));
  }

}
