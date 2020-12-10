package pl.bartflor.riverlog.infrastructure.database.riverlog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bartflor.riverlog.domain.riverlog.User;
import pl.bartflor.riverlog.domain.riverlog.UserRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserDbRepository implements UserRepository {
	UserJpaRepository jpaRepository;
	
	@Override
	public void createUser(User user){
		jpaRepository.save(user);
	}
	
	@Override
	public Optional<User> findUser(String userName) {
		return jpaRepository.findById(userName);
	}
}
