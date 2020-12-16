package pl.bartflor.riverlog.domain.riverlog;

import pl.bartflor.riverlog.interfaces.rest.RunLogDto;

public interface UserService {
	void registerNewUser(String userName, String name, String surname, String email);
	
	void logNewRun(String userName, RunLogDto runLogDto);
	
	RiverLog getUserRiverLog(String userName);
}
