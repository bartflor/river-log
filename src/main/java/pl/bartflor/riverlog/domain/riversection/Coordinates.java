package pl.bartflor.riverlog.domain.riversection;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Coordinates {
	Double longitude;
	Double latitude;
	
}
