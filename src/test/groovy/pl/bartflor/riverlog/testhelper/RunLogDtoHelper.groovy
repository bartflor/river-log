package pl.bartflor.riverlog.testhelper


import pl.bartflor.riverlog.interfaces.rest.RunLogDto

import static spock.genesis.Gen.*

class RunLogDtoHelper {

	static RunLogDto createRandom(){
		RunLogDto.builder()
				.logText(string(50).first())
				.date(date.first().toInstant())
				.sectionId(getLong().first())
				.build()
	}
}
