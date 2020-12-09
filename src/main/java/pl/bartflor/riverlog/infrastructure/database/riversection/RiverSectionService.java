package pl.bartflor.riverlog.infrastructure.database.riversection;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import java.util.List;

@Service
@AllArgsConstructor
public class RiverSectionService {
	RiverSectionRepository sectionRepository;
	
	public void addNewSection(RiverSection riverSection){
		sectionRepository.save(RiverSectionEntity.from(riverSection));
	}
	
	public List<RiverSection> getAll() {
		return sectionRepository.getAllSections();
	}
}
