package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartflor.riverlog.domain.riverlog.exception.UserNotFoundException;
import pl.bartflor.riverlog.domain.riversection.RiverSection;
import pl.bartflor.riverlog.domain.riversection.RiverSectionService;
import pl.bartflor.riverlog.interfaces.rest.RunLogDto;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserService {
	private static final String USER_WITH_USERNAME_NOT_FOUND = "User with user name: %s, not found";
	UserRepository userRepository;
	RiverLogRepository riverLogRepository;
	RiverSectionService riverSectionService;
	
	public void registerNewUser(String userName, String name, String surname, String email){
		User newUser = User.builder()
				.userName(userName)
				.name(name)
				.surname(surname)
				.email(email)
				.build();
		userRepository.createUser(newUser);
		
	}
	
	public void logNewRun(String userName, RunLogDto runLogDto){
		RiverSection riverSection = riverSectionService.getSectionById(runLogDto.getSectionId());
		User user = userRepository.findUser(userName)
				.orElseThrow(() ->
						new UserNotFoundException(String.format(USER_WITH_USERNAME_NOT_FOUND, userName)));
		user.logNewRun(RunLog.builder()
				.logText(runLogDto.getLogText())
				.date(runLogDto.getDate())
				.section(riverSection)
				.runType(runLogDto.getRunType())
				.build());
		riverLogRepository.updateUserLog(userName, user.getRiverLog());
	}
	
	public RiverLog getUserRiverLog(String userName) {
		User user =  userRepository.findUser(userName)
				.orElseThrow(() ->
						new UserNotFoundException(String.format(USER_WITH_USERNAME_NOT_FOUND, userName)));
		return user.getRiverLog();
	}
}
