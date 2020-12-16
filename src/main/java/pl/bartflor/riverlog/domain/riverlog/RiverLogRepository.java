package pl.bartflor.riverlog.domain.riverlog;

import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface RiverLogRepository {
	void updateUserLog(String userName, RiverLog riverLog);
	
	void saveRiverLog(RiverLog riverLog);
	
	Optional<RiverLog> getRiverLogById(Long id);
}
