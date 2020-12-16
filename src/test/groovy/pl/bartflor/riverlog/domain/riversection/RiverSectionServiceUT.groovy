package pl.bartflor.riverlog.domain.riversection

import pl.bartflor.riverlog.domain.riversection.exception.SectionNotFoundException
import spock.genesis.Gen
import spock.lang.Specification
import spock.lang.Subject

class RiverSectionServiceUT extends Specification {

	def sectionRepositoryMock = Mock(RiverSectionRepository)
	@Subject
	def sectionService	= new RiverSectionServiceImpl(sectionRepositoryMock)


	def "GetSectionById should throw exception when section with given id not exist"() {
		given:
			def randId = Gen.integer.first()
		when:
			sectionService.getSectionById(randId)
		then:
			1 * sectionRepositoryMock.findSectionById(randId) >> Optional.empty()
		and:
			def e = thrown(SectionNotFoundException)
			e.getMessage() == "Section with id: "+randId+", not found"
	}

	def "GiveSectionOpinion should add given opinion object to proper section"() {
		given:
			def randId = Gen.integer.first()
			def opinion = Mock(Opinion)
			def section = Mock(RiverSection)
		when:
			sectionService.giveSectionOpinion(randId, opinion)
		then:
			1 * sectionRepositoryMock.findSectionById(randId) >> Optional.of(section)
			1 * section.addOpinion(opinion)
			1 * sectionRepositoryMock.save(section)
	}
}
