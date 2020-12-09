package pl.bartflor.riverlog.infrastructure.filedatasource

import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Subject

class RivermapSourceTest extends Specification {
	@Subject
	RivermapSource rivermapSource = new RivermapSource(new RestTemplate())

	def "GetSections"() {
		expect:
			System.out.println("----> "+rivermapSource.checkDataTimeStamp().toString())
			System.out.println(rivermapSource.getSections().toString())

	}
}
