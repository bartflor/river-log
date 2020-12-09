package pl.bartflor.riverlog.infrastructure.database.riversection;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class RiverSectionRepository {
	RiverSectionJpaRepository jpaRepository;
	
	public void save(RiverSectionEntity riverSectionEntity){
		jpaRepository.save(riverSectionEntity);
	}
	
	public List<RiverSection> getAllSections() {
		return jpaRepository.findAll().stream()
				.map(RiverSectionEntity::toDomain)
				.collect(Collectors.toList());
	}
	
}
