package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class RiverLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "river_log_id")
	List<RunLog> runLogList;
	
	public void addNewLog(RunLog runLog) {
		runLogList.add(runLog);
	}
}
