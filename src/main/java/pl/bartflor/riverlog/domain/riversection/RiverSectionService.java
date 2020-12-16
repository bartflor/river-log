package pl.bartflor.riverlog.domain.riversection;

import java.util.List;

public interface RiverSectionService {
	void saveSection(RiverSection riverSection);
	
	List<RiverSection> getAll();
	
	RiverSection getSectionById(Long sectionId);
	
	void giveSectionOpinion(Long sectionId, Opinion opinion);
}
