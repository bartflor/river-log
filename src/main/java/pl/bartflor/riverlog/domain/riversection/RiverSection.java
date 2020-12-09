package pl.bartflor.riverlog.domain.riversection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiverSection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String riverName;
	private String sectionName;
	private SectionType sectionType;
	@Embedded
	private Coordinates start;
	@Embedded
	private Coordinates end;
	private String grade;
	private String spotsGrade;
	private String country;
	private URL mapUrl;
	@OneToMany
	@Builder.Default private List<Opinion> opinionList = new ArrayList<>();
	@Builder.Default private boolean currentlyExistingHazard = false;
	
	public enum SectionType {
		SECTION, PLAYSPOT, DROP, SLALOM
	}
	
	public void giveOpinion(Opinion opinion){
		opinionList.add(opinion);
	}
	
}
