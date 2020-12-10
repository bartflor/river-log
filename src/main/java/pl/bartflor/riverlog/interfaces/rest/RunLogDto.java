package pl.bartflor.riverlog.interfaces.rest;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartflor.riverlog.domain.riverlog.RunLog;

import java.time.Instant;

@NoArgsConstructor
@Data
public class RunLogDto {
	Instant date;
	String logText;
	Long sectionId;
	RunLog.RunType runType;
	
}
