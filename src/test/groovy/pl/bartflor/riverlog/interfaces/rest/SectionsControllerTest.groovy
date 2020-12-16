package pl.bartflor.riverlog.interfaces.rest

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import pl.bartflor.riverlog.domain.riversection.RiverSection
import pl.bartflor.riverlog.domain.riversection.RiverSectionService
import pl.bartflor.riverlog.testhelper.DomainObjectHelper
import pl.bartflor.riverlog.testhelper.MockServicesInitializer
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(classes = [MockServicesInitializer], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SectionsControllerTest extends Specification {

	@LocalServerPort
	int port

	@Autowired
	RiverSectionService riverSectionServiceMock

	@Shared
	RequestSpecification restClient

	def setup(){
		restClient = RestAssured.given()
				.port(port)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.log().all()
	}


	def "GetAllSections"() {
		given:
			def riverSection = DomainObjectHelper.createSection()
		when:
			def response = restClient.get("/api/sections")
		then:
			riverSectionServiceMock.getAll() >> List.of(riverSection)
			response.getStatusCode() == 200
		and:
			response.then().extract()
					.as(RiverSection[]) == [riverSection] as RiverSection[]


	}

}
