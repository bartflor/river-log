package pl.bartflor.riverlog.infrastructure.filedatasource;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Log
@Component
public class RivermapSource {
	private final String RIVERMAP_DATA_SOURCE_URL;
	
	private final RestTemplate restTemplate;
	
	public RivermapSource(RestTemplateBuilder restTemplateBuilder,
	                      @Value("${data.rivermap.sections}") String url){
		this.restTemplate = restTemplateBuilder.build();
		this.RIVERMAP_DATA_SOURCE_URL = url;
	}
	
	public Instant checkDataTimeStamp(){
		DataTimestampDeserializationWrapper timestampWrapper = restTemplate.getForObject(RIVERMAP_DATA_SOURCE_URL,
						DataTimestampDeserializationWrapper.class);
		if (timestampWrapper == null) {
			throw new RuntimeException();
		}
		return timestampWrapper.getHeader().getTimestamp();
		
	}
	
	public List<SectionDto> getSections(){
		log.info(RIVERMAP_DATA_SOURCE_URL);
		SectionsDeserializationWrapper sectionsWrapper = restTemplate.getForObject(RIVERMAP_DATA_SOURCE_URL,
				SectionsDeserializationWrapper.class);
		if (sectionsWrapper == null) {
			return Collections.EMPTY_LIST;
		}
		return sectionsWrapper.getData().getSections();
		
	}
}
