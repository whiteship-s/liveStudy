package whiteship.toyproject.livestudy.site.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyComment;
import whiteship.toyproject.livestudy.common.model.UserInfo;
import whiteship.toyproject.livestudy.common.repository.CommentRepository;
import whiteship.toyproject.livestudy.common.repository.UserInfoRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserInfoRepository userInfoRepository;

  public List<UserInfo> getUserListBySubject(Integer week) {
    return commentRepository.findAllByStudyCode(Study.findByValue(week))
        .stream()
        .map(StudyComment::getUserInfo)
        .collect(Collectors.toList());
  }
}
