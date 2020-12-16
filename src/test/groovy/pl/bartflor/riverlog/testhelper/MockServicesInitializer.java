package pl.bartflor.riverlog.testhelper;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import pl.bartflor.riverlog.domain.riverlog.UserService;
import pl.bartflor.riverlog.domain.riversection.RiverSectionService;
import spock.mock.DetachedMockFactory;

@TestConfiguration
public class MockServicesInitializer {
	
	DetachedMockFactory mockFactory = new DetachedMockFactory();
	
	@Primary
	@Bean
	public UserService userService(){
		return mockFactory.Mock(UserService.class);
	}
	
	@Primary
	@Bean
	public RiverSectionService riverSectionService(){
		return mockFactory.Mock(RiverSectionService.class);
	}
}
