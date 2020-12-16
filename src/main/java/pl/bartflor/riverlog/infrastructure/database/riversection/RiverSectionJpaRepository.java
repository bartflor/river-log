package pl.bartflor.riverlog.infrastructure.database.riversection;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

public interface RiverSectionJpaRepository extends JpaRepository<RiverSection, Long> {

}
