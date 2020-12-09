package pl.bartflor.riverlog.domain.riverlog;

import pl.bartflor.riverlog.domain.riversection.RiverSection;

import java.time.Instant;

public class RunLog {
	Instant date;
	String logText;
	RiverSection section;
	RunType runType;
	
	public enum RunType{
		TRIP, TRAINING, FREESTYLE_SESSION
	}
}
