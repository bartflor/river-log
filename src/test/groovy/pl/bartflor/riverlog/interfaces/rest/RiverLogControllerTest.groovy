package pl.bartflor.riverlog.interfaces.rest

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import pl.bartflor.riverlog.domain.riverlog.RiverLog
import pl.bartflor.riverlog.domain.riverlog.UserService
import pl.bartflor.riverlog.testhelper.MockServicesInitializer
import pl.bartflor.riverlog.testhelper.DomainObjectHelper
import spock.genesis.Gen
import spock.lang.Specification

@SpringBootTest(classes = [MockServicesInitializer], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class RiverLogControllerTest extends Specification {
	@LocalServerPort
	int randomPort
	RequestSpecification restClient
	@Autowired
	UserService userServiceMock

	def setup(){
		restClient = RestAssured.given()
				.port(randomPort)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.log().all()
	}

	def "GetUserRiverLog"() {
		given:
			def userName = Gen.string(1,10).first()
			def riverLog = DomainObjectHelper.createRiverLog()
		when:
			def response = restClient.get("/api/river-log/"+userName)
		then:
			1 * userServiceMock.getUserRiverLog(userName) >> riverLog
		and:
			response.statusCode() == 200
			response.then().assertThat()
					.extract()
					.as(RiverLog) == riverLog

	}

}
