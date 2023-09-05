package main.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.model.Tour;
import main.service.TourService;

@RestController
@RequestMapping("/api")
public class TourRestController {

	@Autowired
	private TourService tourService;
	
	@GetMapping("/tours")
	public List<Tour> getTours(){
		return tourService.getAll();
	}
}
