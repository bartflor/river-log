package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartflor.riverlog.domain.riverlog.exception.UserNotFoundException;
import pl.bartflor.riverlog.domain.riversection.RiverSection;
import pl.bartflor.riverlog.domain.riversection.RiverSectionService;
import pl.bartflor.riverlog.interfaces.rest.RunLogDto;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private static final String USER_WITH_USERNAME_NOT_FOUND = "User with user name: %s, not found";
	UserRepository userRepository;
	RiverLogRepository riverLogRepository;
	RiverSectionService riverSectionService;
	
	@Override
	public void registerNewUser(String userName, String name, String surname, String email){
		User newUser = User.builder()
				.userName(userName)
				.name(name)
				.surname(surname)
				.email(email)
				.build();
		userRepository.createUser(newUser);
	}
	
	@Override
	public void logNewRun(String userName, RunLogDto runLogDto){
		RiverSection riverSection = riverSectionService.getSectionById(runLogDto.getSectionId());
		User user = findUser(userName);
		user.logNewRun(runLogDto.mapToDomain(riverSection));
		riverLogRepository.updateUserLog(userName, user.getRiverLog());
	}
	
	@Override
	public RiverLog getUserRiverLog(String userName) {
		User user = findUser(userName);
		return user.getRiverLog();
	}
	
	private User findUser(String userName) {
		return userRepository.findUser(userName)
				.orElseThrow(() ->
						new UserNotFoundException(String.format(USER_WITH_USERNAME_NOT_FOUND, userName)));
	}
}
