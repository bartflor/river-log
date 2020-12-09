package pl.bartflor.riverlog.infrastructure.filedatasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartflor.riverlog.domain.riversection.Coordinates;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import java.net.URL;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionDto {
	private int id;
	private String river;
	private String section;
	private String type;
	private Double latstart;
	private Double lngstart;
	private Double latend;
	private Double lngend;
	private String generalGrade;
	private String spotGrades;
	private String country;
	private URL url;
	
	public RiverSection toDomain(){
		return RiverSection.builder()
				.riverName(this.river)
				.sectionName(this.section)
				.sectionType(RiverSection.SectionType.valueOf(type.toUpperCase()))
				.start(Coordinates.builder()
						.latitude(this.latstart)
						.longitude(this.lngstart)
						.build())
				.end(Coordinates.builder()
						.latitude(this.latend)
						.longitude(this.lngend)
						.build())
				.grade(this.generalGrade)
				.spotsGrade(this.spotGrades)
				.country(this.country)
				.mapUrl(this.url)
				.build();
	}
	
}

