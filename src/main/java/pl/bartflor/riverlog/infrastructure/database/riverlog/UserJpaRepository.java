package pl.bartflor.riverlog.infrastructure.database.riverlog;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartflor.riverlog.domain.riverlog.User;

public interface UserJpaRepository extends JpaRepository<User, String> {
}
