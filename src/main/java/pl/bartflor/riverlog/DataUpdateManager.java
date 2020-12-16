package pl.bartflor.riverlog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bartflor.riverlog.domain.riversection.RiverSectionService;
import pl.bartflor.riverlog.infrastructure.filedatasource.RivermapSource;
import pl.bartflor.riverlog.infrastructure.filedatasource.SectionDto;

@Component
@AllArgsConstructor
public class DataUpdateManager {
	RivermapSource rivermapSource;
	RiverSectionService sectionService;
	
	public void updateDbRecords(){
		rivermapSource.getSections().stream()
				.map(SectionDto::toDomain)
				.forEach(riverSection -> sectionService.saveSection(riverSection));
	}
}
