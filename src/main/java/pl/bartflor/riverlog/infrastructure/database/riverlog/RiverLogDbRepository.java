package pl.bartflor.riverlog.infrastructure.database.riverlog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.bartflor.riverlog.domain.riverlog.RiverLog;
import pl.bartflor.riverlog.domain.riverlog.RiverLogRepository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class RiverLogDbRepository implements RiverLogRepository {
	RiverLogJpaRepository jpaRepository;
	
	@Override
	public void updateUserLog(String userName, RiverLog riverLog) {
		jpaRepository.save(riverLog);
	}
	
	@Override
	public void saveRiverLog(RiverLog riverLog){
		jpaRepository.save(riverLog);
	}
	
	@Override
	public Optional<RiverLog> getRiverLogById(Long id){
		return jpaRepository.findById(id);
	}
}
