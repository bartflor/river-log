package pl.bartflor.riverlog.infrastructure.database.riversection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bartflor.riverlog.domain.riversection.RiverSection;
import pl.bartflor.riverlog.domain.riversection.RiverSectionRepository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RiverSectionDbRepository implements RiverSectionRepository {
	RiverSectionJpaRepository jpaRepository;
	
	public void save(RiverSection riverSectionEntity){
		jpaRepository.save(riverSectionEntity);
	}
	
	public List<RiverSection> getAllSections() {
		return jpaRepository.findAll();
	}
	
	@Override
	public Optional<RiverSection> findSectionById(Long sectionId) {
		return jpaRepository.findById(sectionId);
	}
	
}
