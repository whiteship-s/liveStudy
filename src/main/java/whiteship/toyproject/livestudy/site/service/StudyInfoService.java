package whiteship.toyproject.livestudy.site.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

public interface StudyInfoService {

  StudyInfo selectIssue(Integer week) throws NotFoundException;

  Long countEmoji(Integer week);
}
