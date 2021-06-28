package whiteship.toyproject.livestudy.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestudy.common.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
