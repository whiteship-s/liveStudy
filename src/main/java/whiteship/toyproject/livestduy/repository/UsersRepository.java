package whiteship.toyproject.livestduy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.toyproject.livestduy.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
