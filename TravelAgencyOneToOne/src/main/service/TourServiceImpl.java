package main.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.dao.TourDAO;
import main.model.Tour;
import main.model.TourDetails;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourDAO tourDAO;

	@Override
	public List<Tour> getAll() {		
		return tourDAO.getAll();
	}

	@Override
	public Tour getById(int id) {		
		return tourDAO.getById(id);
	}

	@Override
	public void saveOrUpadate(Tour tour) {
		tourDAO.saveOrUpadate(tour);		
	}

	@Override
	public void delete(int id) {
		tourDAO.delete(id);		
	}

	@Override
	public void addTourDetailsIfNotExists(Tour tour) {
		if(tour.getTourDetails() == null) {
			tour.setTourDetails(new TourDetails());
			saveOrUpadate(tour);
		}
		
	}

}
