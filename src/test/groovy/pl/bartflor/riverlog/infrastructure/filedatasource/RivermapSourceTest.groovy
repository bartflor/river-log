package pl.bartflor.riverlog.infrastructure.filedatasource

import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import pl.bartflor.riverlog.testhelper.RivermapCommunicationHelper
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject
import static com.github.tomakehurst.wiremock.client.WireMock.*;

class RivermapSourceTest extends Specification {
	def RANDOM_PORT = 0
	WireMockServer wireMockServer = new WireMockServer(RANDOM_PORT)
	def url = "/extract.json"

	@Subject
	RivermapSource rivermapSource

	def setup(){
		wireMockServer.start()
		rivermapSource = new RivermapSource(new RestTemplateBuilder(),  "http://localhost:"+wireMockServer.port()+ url)
	}

	def cleanup(){
		wireMockServer.stop()
	}

	def "GetSections"() {
		given:
			wireMockServer.stubFor(get(url)
					.willReturn(aResponse()
							.withStatus(HttpStatus.OK.value())
							.withBody(RivermapCommunicationHelper.rivermapSectionsResponse)
							.withHeader("Content-Type", "application/json")))
		when:
			def result = rivermapSource.getSections()
		then:
			result.size() == 2
	}
}
