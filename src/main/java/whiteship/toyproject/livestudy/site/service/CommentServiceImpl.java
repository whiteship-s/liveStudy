package whiteship.toyproject.livestudy.site.service;

import java.util.List;
import org.springframework.stereotype.Service;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentRepository commentRepository;

  public CommentServiceImpl(
      CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @Override
  public List<StudyComment> selectComments(Integer week) {
    return commentRepository.findAllByStudyCode(Study.findByValue(week));
  }

}
