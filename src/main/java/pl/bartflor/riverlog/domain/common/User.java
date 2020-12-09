package pl.bartflor.riverlog.domain.common;

import lombok.Data;
import pl.bartflor.riverlog.domain.riverlog.RiversLog;
import pl.bartflor.riverlog.domain.riverlog.RunLog;

@Data
public class User {
	private String userName;
	private String name;
	private String surname;
	private String email;
	private RiversLog userLog;
	
	public void logNewRun(RunLog runLog){
	
	}
}
