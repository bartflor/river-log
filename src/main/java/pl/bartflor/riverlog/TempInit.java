package pl.bartflor.riverlog;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.bartflor.riverlog.domain.riverlog.UserService;

@Log
@Component
@AllArgsConstructor
public class TempInit implements CommandLineRunner {
	private final UserService userService;
	private final DataUpdateManager updateManager;
	
	@Override
	public void run(String... args) {
		log.info("DB init");
		updateManager.updateDbRecords();
		userService.registerNewUser("testPaddler", "tname", "tsurname", "tpaddler@mail.com");
	}
}
