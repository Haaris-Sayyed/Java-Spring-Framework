package main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.model.Tour;

@Repository
public class TourDAOImpl implements TourDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Tour> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Tour t", Tour.class).list();
	}

	@Override
	public Tour getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Tour.class, id);
	}

	@Override
	public void saveOrUpdate(Tour tour) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tour);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Tour tour = getById(id);
		session.delete(tour);
	}

	@Override
	public Tour getByIdWithComments(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Tour t left join fetch t.comments where t.id = :id", Tour.class).setParameter("id", id).getSingleResult();
	}

}
