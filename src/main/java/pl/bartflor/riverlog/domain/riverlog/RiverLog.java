package pl.bartflor.riverlog.domain.riverlog;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
public class RiverLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "river_log_id")
	List<RunLog> runLogList;

	public RiverLog(){
		this.runLogList = new ArrayList<>();
	}
	
	public void addNewLog(RunLog runLog) {
		runLogList.add(runLog);
	}
}
