package pl.bartflor.riverlog.infrastructure.database.riversection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartflor.riverlog.domain.riversection.Coordinates;
import pl.bartflor.riverlog.domain.riversection.RiverSection;

import javax.persistence.*;
import java.net.URL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiverSectionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String river;
	private String section;
	@Enumerated(EnumType.STRING)
	private RiverSection.SectionType type;
	private Double startLatitude;
	private Double startLongitude;
	private Double endLatitude;
	private Double endLongitude;
	private String generalGrade;
	private String spotGrades;
	private String country;
	private URL mapUrl;
	
	public static RiverSectionEntity from(RiverSection riverSection) {
		return RiverSectionEntity.builder()
				.river(riverSection.getRiverName())
				.section(riverSection.getSectionName())
				.type(riverSection.getSectionType())
				.startLatitude(riverSection.getStart().getLatitude())
				.startLongitude(riverSection.getStart().getLongitude())
				.endLatitude(riverSection.getEnd().getLatitude())
				.endLongitude(riverSection.getEnd().getLongitude())
				.generalGrade(riverSection.getGrade())
				.spotGrades(riverSection.getSpotsGrade())
				.country(riverSection.getCountry())
				.mapUrl(riverSection.getMapUrl())
				.build();
	}
	
	public RiverSection toDomain() {
		return RiverSection.builder()
				.riverName(this.river)
				.sectionName(this.section)
				.sectionType(this.type)
				.start(Coordinates.builder()
						.latitude(this.startLatitude)
						.longitude(this.startLongitude)
						.build())
				.end(Coordinates.builder()
						.latitude(this.endLatitude)
						.longitude(this.endLongitude)
						.build())
				.grade(this.generalGrade)
				.spotsGrade(this.spotGrades)
				.country(this.country)
				.mapUrl(this.mapUrl)
				.build();
	}
}
