package pl.bartflor.riverlog.domain.riversection;

import java.util.List;
import java.util.Optional;

public interface RiverSectionRepository {
	void save(RiverSection riverSection);
	
	List<RiverSection> getAllSections();
	
	Optional<RiverSection> findSectionById(Long sectionId);
}
