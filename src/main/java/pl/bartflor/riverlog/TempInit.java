package pl.bartflor.riverlog;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.bartflor.riverlog.domain.riverlog.UserServiceImpl;

@Log
@Component
@AllArgsConstructor
@Profile("default")
public class TempInit implements CommandLineRunner {
	private final UserServiceImpl userService;
	private final DataUpdateManager updateManager;
	
	@Override
	public void run(String... args) {
		log.info("DB init");
		updateManager.updateDbRecords();
		userService.registerNewUser("testPaddler", "tname", "tsurname", "tpaddler@mail.com");
	}
}
