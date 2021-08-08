package whiteship.toyproject.livestudy.site.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyInfo;
import whiteship.toyproject.livestudy.common.repository.StudyInfoRepository;

@Service
public class StudyInfoServiceImpl implements StudyInfoService {

  private final StudyInfoRepository studyInfoRepository;


  public StudyInfoServiceImpl(
      StudyInfoRepository studyInfoRepository) {
    this.studyInfoRepository = studyInfoRepository;
  }

  @Override
  public StudyInfo selectIssue(Integer week) throws NotFoundException {
    return studyInfoRepository.findByStudyCode(
        Study.findByValue(week)).orElseThrow(NotFoundException::new);
  }

  @Override
  public Long countEmoji(Integer week) {
    return studyInfoRepository.findCountByStudyCode("EMOJI_300001", Study.findByValue(week));
  }

}
