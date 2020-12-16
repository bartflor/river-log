package pl.bartflor.riverlog.interfaces.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bartflor.riverlog.domain.riverlog.RiverLog;
import pl.bartflor.riverlog.domain.riverlog.UserService;
import pl.bartflor.riverlog.domain.riverlog.UserServiceImpl;


@RestController
@RequestMapping("/api/river-log")
@AllArgsConstructor
public class RiverLogController {
	UserService userService;
	
	@GetMapping("/{userName}")
	public RiverLog getUserRiverLog(@PathVariable String userName){
		return userService.getUserRiverLog(userName);
	}
	
	@PostMapping("/{userName}")
	public void createNewLogEntry(@RequestBody RunLogDto runLogDto, @PathVariable String userName){
		userService.logNewRun(userName, runLogDto);
	}
}
