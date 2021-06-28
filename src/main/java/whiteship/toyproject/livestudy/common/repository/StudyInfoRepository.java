package whiteship.toyproject.livestudy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

public interface StudyInfoRepository extends JpaRepository<StudyInfo, Long> {

}
