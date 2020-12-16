package pl.bartflor.riverlog.interfaces.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartflor.riverlog.domain.riverlog.RunLog;
import pl.bartflor.riverlog.domain.riversection.RiverSection;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RunLogDto {
	Instant date;
	String logText;
	Long sectionId;
	RunLog.RunType runType;
	
	public RunLog mapToDomain(RiverSection section){
		return RunLog.builder()
				.logText(this.logText)
				.date(this.date)
				.section(section)
				.runType(this.runType)
				.build();
	}
}
