package pl.bartflor.riverlog.domain.riverlog;

import java.util.List;

public class RiversLog {
	List<RunLog> runLogList;
	
	public void addNewLog(RunLog runLog) {
		runLogList.add(runLog);
	}
}
