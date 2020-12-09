package pl.bartflor.riverlog.domain.riversection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartflor.riverlog.infrastructure.database.riversection.RiverSectionDbRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RiverSectionService {
	RiverSectionRepository sectionRepository;
	
	public void addNewSection(RiverSection riverSection){
		sectionRepository.save(riverSection);
	}
	
	public List<RiverSection> getAll() {
		return sectionRepository.getAllSections();
	}
}
