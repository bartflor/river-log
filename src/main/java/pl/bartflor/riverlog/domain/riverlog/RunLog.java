package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RunLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Instant date;
	String logText;
	@ManyToOne
	@JoinColumn(name = "river_section_id")
	RiverSection section;
	@Enumerated(EnumType.STRING)
	RunType runType;
	
	public enum RunType{
		TRIP, TRAINING, FREESTYLE_SESSION
	}
}
