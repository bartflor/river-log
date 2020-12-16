package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
	@Id
	private String userName;
	private String name;
	private String surname;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "river_log_id")
	@Builder.Default private RiverLog riverLog = new RiverLog();
	
	public void logNewRun(RunLog runLog){
		riverLog.addNewLog(runLog);
	}
}
