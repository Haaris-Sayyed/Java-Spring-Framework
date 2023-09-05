package main.service;
import java.util.List;
import main.model.Tour;

public interface TourService {
	
	public List<Tour> getAll();	
	
	public Tour getById(int id);
	
	public void saveOrUpadate(Tour tour);
	
	public void delete(int id);
}
