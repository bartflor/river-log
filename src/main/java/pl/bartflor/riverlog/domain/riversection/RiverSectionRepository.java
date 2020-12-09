package pl.bartflor.riverlog.domain.riversection;

import java.util.List;

public interface RiverSectionRepository {
	void save(RiverSection riverSection);
	
	List<RiverSection> getAllSections();
}
