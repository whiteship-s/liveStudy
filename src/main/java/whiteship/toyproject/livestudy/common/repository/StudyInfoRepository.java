package whiteship.toyproject.livestudy.common.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import whiteship.toyproject.livestudy.common.model.StudyInfo;

public interface StudyInfoRepository extends JpaRepository<StudyInfo, Long> {

  Optional<StudyInfo> findByStudyCode(String studyCode);

  @Modifying
  @Query(value = "SELECT count(comment) FROM StudyComment comment"
      + " INNER JOIN Emoji emoji"
      + " ON comment.commentSeq = emoji.studyComment.commentSeq"
      + " WHERE emoji.emojiCode =:emojiCode"
      + " AND comment.studyCode =:studyCode")
  Long findCountByStudyCode(String emojiCode, String studyCode);
}