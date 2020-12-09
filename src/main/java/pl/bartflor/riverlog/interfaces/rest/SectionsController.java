package pl.bartflor.riverlog.interfaces.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bartflor.riverlog.domain.riversection.RiverSection;
import pl.bartflor.riverlog.domain.riversection.RiverSectionService;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
@AllArgsConstructor
public class SectionsController {
	RiverSectionService sectionService;
	
	@GetMapping
	public List<RiverSection> getAllSections(){
		return sectionService.getAll();
	}
	
	
}


