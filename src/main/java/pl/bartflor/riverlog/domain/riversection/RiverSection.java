package pl.bartflor.riverlog.domain.riversection;

import lombok.Builder;
import lombok.Data;
import pl.bartflor.riverlog.domain.riverlog.Coordinates;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class RiverSection {
	private String riverName;
	private String sectionName;
	private SectionType sectionType;
	private Coordinates start;
	private Coordinates end;
	private String grade;
	private String spotsGrade;
	private String country;
	@Builder.Default private List<Opinion> opinionList = new ArrayList<>();
	@Builder.Default private boolean currentlyExistingHazard = false;
	private URL mapUrl;
	
	public enum SectionType {
		SECTION, PLAYSPOT, DROP, SLALOM
	}
	
	public void giveOpinion(Opinion opinion){
		opinionList.add(opinion);
	}
	
}
