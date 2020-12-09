package pl.bartflor.riverlog.domain.riverlog;

import lombok.Data;

@Data
public class User {
	private String userName;
	private String name;
	private String surname;
	private String email;
	private RiversLog userLog;
	
	public void logNewRun(RunLog runLog){
		userLog.addNewLog(runLog);
	}
}
