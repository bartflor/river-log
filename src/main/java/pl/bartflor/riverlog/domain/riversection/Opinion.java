package pl.bartflor.riverlog.domain.riversection;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Opinion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private Double rate;
	private String opinionText;

}
