package pl.bartflor.riverlog.infrastructure.filedatasource;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

import java.util.List;

@Component
public class RivermapSource {
	public static final String RIVERMAP_DATA_SOURCE_URL = "https://www.rivermap.ch//public/ODBL/extract.json";
	
	private RestTemplate restTemplate;
	
	public RivermapSource(RestTemplateBuilder restTemplateBuilder){
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public Instant checkDataTimeStamp(){
		DataTimestampDeserializationWrapper timestampWrapper = restTemplate.getForObject(RIVERMAP_DATA_SOURCE_URL,
						DataTimestampDeserializationWrapper.class);
		return timestampWrapper.getHeader().getTimestamp();
	}
	
	public List<SectionDto> getSections(){
		SectionsDeserializationWrapper sectionsWrapper = restTemplate.getForObject(RIVERMAP_DATA_SOURCE_URL,
				SectionsDeserializationWrapper.class);
		return sectionsWrapper.getData().getSections();
	}
}
