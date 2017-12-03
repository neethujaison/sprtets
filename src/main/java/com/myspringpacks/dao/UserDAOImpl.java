package com.myspringpacks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.myspringpacks.model.City;
import com.myspringpacks.model.Country;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional 
	public List<User> list() {

		List<User> list =(List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}
	
	@Transactional 
	public void addUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}
	@Transactional 
	public User getUser(int user_id) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.get(User.class,user_id);
		return user;
		
	}

	@Transactional
	public void deleteUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM User WHERE user_id="+user.getUser_id()).executeUpdate();
		
	}

	@Transactional
	public void saveFile(UploadFile file) {
		Session session=sessionFactory.getCurrentSession();
		session.save(file);
	}

	@Transactional 
	public List<Country> getCountryList() {
		String hql = "SELECT country_id, country_name FROM Country";
		Session session=sessionFactory.getCurrentSession();
		List<Country> list =(List<Country>)session.createQuery(hql).list();
	    return list;
		
	}

	@Transactional
	public List<City> retrieveCities(int countryId) {
		String hql = "SELECT city_id, city_name FROM City where country_id="+countryId;
		Session session=sessionFactory.getCurrentSession();
		List<City> list =(List<City>)session.createQuery(hql).list();
		return list;
	}

}
