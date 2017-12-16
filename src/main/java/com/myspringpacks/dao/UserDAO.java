package com.myspringpacks.dao;

import java.util.List;
import java.util.Map;

import com.myspringpacks.entity.UserForm;
import com.myspringpacks.model.Ahm;
import com.myspringpacks.model.City;
import com.myspringpacks.model.Fhl;
import com.myspringpacks.model.Hawbs;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;

public interface UserDAO {
	public List<User> list();
	public void addUser(User user);
	public void deleteUser(User user);
	public User getUser(int user_id);
	public void saveFile(UploadFile file);
	public List<City> retrieveCities(int countryId);
	public List<User> findUser(String pSearchTerm);
	public List<User> getUsersByPage(int pageid,int total);
	public int addAhm(Ahm ahm);
	public int addHawb(Hawbs hawb);
	public int addFhl(Fhl fhl);
	public List<Hawbs> getHawbList(Ahm ahm);
	public void deleteAllHawb(List<Hawbs> hawbListToBeDeleted);
	public void deleteAllFhl(List<Hawbs> hawbListToBeDeleted);
	public Hawbs getHawb(int hawbId);

}
