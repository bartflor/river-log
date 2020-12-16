package pl.bartflor.riverlog.domain.riversection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bartflor.riverlog.domain.riversection.exception.SectionNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class RiverSectionServiceImpl implements RiverSectionService {
	private static final String SECTION_WITH_ID_NOT_FOUND = "Section with id: %s, not found";
	RiverSectionRepository sectionRepository;
	
	@Override
	public void saveSection(RiverSection riverSection){
		sectionRepository.save(riverSection);
	}
	
	@Override
	public List<RiverSection> getAll() {
		return sectionRepository.getAllSections();
	}
	
	@Override
	public RiverSection getSectionById(Long sectionId) {
		return sectionRepository.findSectionById(sectionId)
				.orElseThrow(() ->
						new SectionNotFoundException(String.format(SECTION_WITH_ID_NOT_FOUND, sectionId)));
	}
	
	@Override
	public void giveSectionOpinion(Long sectionId, Opinion opinion){
		RiverSection section = getSectionById(sectionId);
		section.addOpinion(opinion);
		saveSection(section);
	}
}
