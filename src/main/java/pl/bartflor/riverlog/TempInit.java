package pl.bartflor.riverlog;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Log
@Component
@AllArgsConstructor
public class TempInit implements CommandLineRunner {
	
	private final DataUpdateManager updateManager;
	
	@Override
	public void run(String... args) {
		log.info("DB init");
		updateManager.updateDbRecords();
	}
}
