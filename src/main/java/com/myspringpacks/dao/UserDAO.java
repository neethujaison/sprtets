package com.myspringpacks.dao;

import java.util.List;
import java.util.Map;

import com.myspringpacks.entity.UserForm;
import com.myspringpacks.model.City;
import com.myspringpacks.model.Country;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;

public interface UserDAO {
	public List<User> list();
	public void addUser(User user);
	public void deleteUser(User user);
	public User getUser(int user_id);
	public void saveFile(UploadFile file);
	public List<Country> getCountryList();
	public List<City> retrieveCities(int countryId);

}
