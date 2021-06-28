package whiteship.toyproject.livestudy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestudy.common.model.Emoji;

public interface EmojiRepository extends JpaRepository<Emoji, Long> {

}
