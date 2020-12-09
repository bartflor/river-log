package pl.bartflor.riverlog.domain.riverlog;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Coordinates {
	Double longitude;
	Double latitude;
}
