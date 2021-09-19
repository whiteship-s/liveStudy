package whiteship.toyproject.livestudy.site.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import whiteship.toyproject.livestudy.common.code.Study;
import whiteship.toyproject.livestudy.common.model.StudyInfo;
import whiteship.toyproject.livestudy.common.repository.StudyInfoRepository;

@Service
public class StudyInfoService1 {

  private final StudyInfoRepository studyInfoRepository;


  public StudyInfoService1(
      StudyInfoRepository studyInfoRepository) {
    this.studyInfoRepository = studyInfoRepository;
  }

  public StudyInfo selectIssue(Integer week) throws NotFoundException {
    return studyInfoRepository.findByStudyCode(
        Study.findByValue(week)).orElseThrow(NotFoundException::new);
  }

  public Long countEmoji(Integer week) {
    return studyInfoRepository.findCountByStudyCode("EMOJI_300001", Study.findByValue(week));
  }

}
