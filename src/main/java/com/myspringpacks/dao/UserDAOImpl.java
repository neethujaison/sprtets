package com.myspringpacks.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.myspringpacks.model.Ahm;
import com.myspringpacks.model.City;
import com.myspringpacks.model.Fhl;
import com.myspringpacks.model.Hawbs;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> list() {

		List<User> list = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

	@Transactional
	public User getUser(int user_id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, user_id);
		return user;

	}

	@Transactional
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM User WHERE user_id=" + user.getUser_id()).executeUpdate();

	}

	@Transactional
	public void saveFile(UploadFile file) {
		Session session = sessionFactory.getCurrentSession();
		session.save(file);
	}

	/*
	 * @Transactional public List<Country> getCountryList() { String hql =
	 * "SELECT country_id, country_name FROM Country"; Session
	 * session=sessionFactory.getCurrentSession(); List<Country> list
	 * =(List<Country>)session.createQuery(hql).list(); return list;
	 * 
	 * }
	 */

	@Transactional
	public List<City> retrieveCities(int countryId) {
		String hql = "SELECT city_id, city_name FROM City where country_id=" + countryId;
		Session session = sessionFactory.getCurrentSession();
		List<City> list = (List<City>) session.createQuery(hql).list();
		return list;
	}

	@Transactional
	public List<User> findUser(String pSearchTerm) {
		String hql = "SELECT user_id,user_name,user_contactno,user_username,user_password FROM User where user_name like '"
				+ pSearchTerm + "'";
		System.out.println(hql);
		Session session = sessionFactory.getCurrentSession();
		List<User> list = (List<User>) session.createQuery(hql).list();
		System.out.println(list.get(0).getUser_name());
		return list;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getUsersByPage(int pageid, int total) {
		String hql = "select user_id,user_name,user_contactno,user_username,user_password  from User";
		// String hql = "SELECT country_id, country_name FROM Country";
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) session.createQuery(hql).list();
		System.out.println(hql);
		System.out.println(list.get(0).getUser_name());
		return list;
	}

	@Transactional
	public int addAhm(Ahm ahm) {
		int ahmId = 0;
		Session session = sessionFactory.getCurrentSession();
		if (ahm != null)
			ahmId = (Integer) session.save(ahm);
		return ahmId;

	}

	@Transactional
	public int addHawb(Hawbs hawb) {
		int hawbId = 0;
		Session session = sessionFactory.getCurrentSession();
		if (hawb != null)
			hawbId = (Integer) session.save(hawb);
		return hawbId;
	}

	@Transactional
	public int addFhl(Fhl fhl) {
		int fhlId = 0;
		Session session = sessionFactory.getCurrentSession();
		if (fhl != null)
			fhlId = (Integer) session.save(fhl);
		return fhlId;
	}

	@Transactional
	public List<Hawbs> getHawbList(Ahm ahm) {
		System.out.println(ahm + "list goes here");
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Hawbs h where h.cra_ahm_detail_stg_id = :ahmId";
		List<Hawbs> list = (List<Hawbs>) session.createQuery(hql).setParameter("ahmId", ahm.getCra_ahm_detail_stg_id())
				.list();

		
		return list;
	}

	
	@Transactional
	public void deleteAllHawb(List<Hawbs> hawbListToBeDeleted) {
		System.out.println("iamhere");
		List<Integer> hawbIds = new ArrayList<Integer>() ;
		
		if(hawbListToBeDeleted!=null && !(hawbListToBeDeleted.isEmpty())){
			for(Hawbs hawb:hawbListToBeDeleted){
				hawbIds.add(hawb.getCra_hawb_detail_stg_id());
			}
		}
		System.out.println("iamhere2"+hawbIds);
		
		Session session=sessionFactory.getCurrentSession();
		String hql;
		if (hawbIds != null && !hawbIds.isEmpty()) {
			for(Integer hawbId:hawbIds){
				hql="delete from Hawbs h where h.cra_hawb_detail_stg_id IN :hawbId";
				Query qry=session.createQuery(hql).setParameter("hawbId",hawbId);
				qry.executeUpdate();
				System.out.println("Performed deleted"+hawbId);
			}
		}
		 
		
	}
	@Transactional
	public void deleteAllFhl(List<Hawbs> hawbListToBeDeleted) {
		/*ArrayList<Integer> fhlIds = new ArrayList<Integer>();
		if(hawbListToBeDeleted!=null && !(hawbListToBeDeleted.isEmpty())){
			for(Hawbs hawb:hawbListToBeDeleted){
				fhlIds.add(hawb.getCra_fhl_upload_detail_id());
			}
		}
		Session session=sessionFactory.getCurrentSession();
		String hql="delete from Fhl h where h.cra_fhl_upload_detail_id IN (:fhlIds)";
		System.out.println(hql + "Deleted");
		if(!(fhlIds.isEmpty())){
				@SuppressWarnings("unchecked")
				Query qry=session.createQuery(hql).setParameter("fhlIds", fhlIds);
				qry.executeUpdate();
				System.out.println("Deleted");
		}
		*/
		System.out.println("iamhere");
		List<Integer> fhlIds = new ArrayList<Integer>() ;		
		if(hawbListToBeDeleted!=null && !(hawbListToBeDeleted.isEmpty())){
			for(Hawbs hawb:hawbListToBeDeleted){
				fhlIds.add(hawb.getCra_fhl_upload_detail_id());
			}
		}
		System.out.println("iamhere2"+fhlIds);
		
		Session session=sessionFactory.getCurrentSession();
		String hql;
		if (fhlIds != null && !fhlIds.isEmpty()) {
			for(Integer fhlId:fhlIds){
				hql="delete from Fhl h where h.cra_fhl_upload_detail_id IN :fhlId";
				Query qry=session.createQuery(hql).setParameter("fhlId",fhlId);
				qry.executeUpdate();
				System.out.println("Performed deleted"+fhlId);
			}
		}
	}
	@Transactional
	public Hawbs getHawb(int hawbId){
		Session session=sessionFactory.getCurrentSession();
		String hql="select h from Hawbs h where h.cra_hawb_detail_stg_id = :hawbId)";
		Query qry=session.createQuery(hql).setParameter("hawbId", hawbId);
		List results= qry.list();
		Hawbs hawb=null;
		if((results!=null) && !(results.isEmpty())){
			hawb = (Hawbs) results.get(0);
		}
		System.out.println("------------------hawb---------------"+hawb);
		return hawb;
	}

}
