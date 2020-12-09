package pl.bartflor.riverlog.infrastructure.filedatasource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTimestampDeserializationWrapper {
	Header header;
	
	@Data
	static class Header {
		Instant timestamp;

	}
}
