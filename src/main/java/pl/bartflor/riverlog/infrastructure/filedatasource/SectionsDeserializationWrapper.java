package pl.bartflor.riverlog.infrastructure.filedatasource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tools.ant.taskdefs.email.Header;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionsDeserializationWrapper {
	SectionList data;
	
	@Data
	static class SectionList {
		List<SectionDto> sections;
		
		public SectionList(){
			this.sections = new ArrayList<>();
		}
	}
}
