package pl.bartflor.riverlog.domain.riversection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiverSection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String riverName;
	private String sectionName;
	@Enumerated(EnumType.STRING)
	private SectionType sectionType;
	@Embedded
	@AttributeOverride(name = "longitude", column = @Column(name = "start_longitude"))
	@AttributeOverride(name = "latitude", column = @Column(name = "start_latitude"))
	private Coordinates start;
	@Embedded
	@AttributeOverride(name = "longitude", column = @Column(name = "end_longitude"))
	@AttributeOverride(name = "latitude", column = @Column(name = "end_latitude"))
	private Coordinates end;
	private String grade;
	private String spotsGrade;
	private String country;
	private URL mapUrl;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "river_section_id")
	@Builder.Default private List<Opinion> opinionList = new ArrayList<>();
	@Builder.Default private boolean currentlyExistingHazard = false;
	
	public enum SectionType {
		SECTION, PLAYSPOT, DROP, SLALOM
	}
	
	public void addOpinion(Opinion opinion){
		opinionList.add(opinion);
	}
	
}
