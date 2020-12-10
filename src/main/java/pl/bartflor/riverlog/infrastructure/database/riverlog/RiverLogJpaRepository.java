package pl.bartflor.riverlog.infrastructure.database.riverlog;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartflor.riverlog.domain.riverlog.RiverLog;

public interface RiverLogJpaRepository extends JpaRepository<RiverLog, Long> {

}
