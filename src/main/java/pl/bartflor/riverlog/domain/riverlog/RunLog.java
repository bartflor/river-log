package pl.bartflor.riverlog.domain.riverlog;

import lombok.Builder;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import java.time.Instant;

@Builder
public class RunLog {
	Instant date;
	String logText;
	RiverSection section;
	RunType runType;
	
	public enum RunType{
		TRIP, TRAINING, FREESTYLE_SESSION
	}
}
