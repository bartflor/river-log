package pl.bartflor.riverlog.domain.riverlog;

import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface UserRepository {
	void createUser(User user);
	
	Optional<User> findUser(String userName);
}
