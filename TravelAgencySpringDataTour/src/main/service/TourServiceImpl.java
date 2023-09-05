package main.service;

import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Tour;
import main.model.User;
import main.repository.TourRepository;
import main.repository.UserRepository;

@Service
@Transactional
public class TourServiceImpl implements TourService{

	@Autowired
	private TourRepository tourRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Tour> getAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour getById(int id) {
		return tourRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		tourRepository.save(tour);
	}

	@Override
	public void delete(int id) {
		tourRepository.deleteById(id);
	}

	@Override
	public Tour getByIdWithComments(int id) {
		return tourRepository.getByIdWithComments(id);
	}

	@Override
	public void addUserToTour(int id, int userId) {
		Tour tour = getById(id);
		if(tour.getUsers() == null) {
			tour.setUsers(new ArrayList<>());
		}
		User user = userRepository.getOne(userId);
		if(user != null) {
			tour.getUsers().add(user);
			saveOrUpdate(tour);
		}
	}

	@Override
	public List<Tour> getAllForNextMonth() {
		Date currentDate = new Date();
		Calendar calender = Calendar.getInstance();
		calender.setTime(currentDate);
		calender.add(Calendar.MONTH, 1);		
		return tourRepository.findByDateBetween(currentDate, calender.getTime());
	}

}
