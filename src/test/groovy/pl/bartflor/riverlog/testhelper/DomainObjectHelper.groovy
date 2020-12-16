package pl.bartflor.riverlog.testhelper

import pl.bartflor.riverlog.domain.riverlog.RiverLog
import pl.bartflor.riverlog.domain.riverlog.RunLog
import pl.bartflor.riverlog.domain.riversection.Coordinates
import pl.bartflor.riverlog.domain.riversection.RiverSection
import spock.genesis.Gen

class DomainObjectHelper {

	static RiverLog createRiverLog(){
		new RiverLog(Gen.integer.first(), List.of(createRunLog()))
	}

	static RunLog createRunLog(){
		RunLog.builder()
		.id(Gen.integer.first())
		.date(Gen.date.first().toInstant())
		.logText(Gen.string(100).first())
		.runType(RunLog.RunType.FREESTYLE_SESSION)
		.build()
	}

	static RiverSection createSection(){
		RiverSection.builder()
				.riverName(Gen.string(10).first())
				.sectionName(Gen.string(10).first())
				.sectionType(RiverSection.SectionType.SECTION)
				.start(Coordinates.builder()
						.latitude(Gen.integer.first())
						.longitude(Gen.integer.first())
						.build())
				.end(Coordinates.builder()
						.latitude(Gen.integer.first())
						.longitude(Gen.integer.first())
						.build())
				.grade(Gen.string(10).first())
				.spotsGrade(Gen.string(10).first())
				.country(Gen.string(10).first())
				.build()
	}
}
