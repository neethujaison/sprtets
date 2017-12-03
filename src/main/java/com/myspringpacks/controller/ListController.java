package com.myspringpacks.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myspringpacks.dao.UserDAO;
import com.myspringpacks.entity.CustomerForm;
import com.myspringpacks.entity.UserForm;
import com.myspringpacks.exception.UserNotFoundException;
import com.myspringpacks.json.UserJSONResponse;
import com.myspringpacks.model.City;
import com.myspringpacks.model.Country;
import com.myspringpacks.model.Customer;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;
import com.myspringpacks.validator.CustomerValidator;
import com.myspringpacks.validator.UserValidataor;

@Controller
public class ListController {

	private String loc = "D:/uploads/";

	@Autowired
	private UserDAO userDao;

	@Autowired
	private UserValidataor userValidator;
	
	@Autowired 
	private CustomerValidator customerValidator;

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		//binder.addValidators(userValidator);
		binder.addValidators(customerValidator);
	}

	@RequestMapping(value = "/showList", method = RequestMethod.GET)
	public ModelAndView showListPage() {
		List list = userDao.list();
		return new ModelAndView("list", "list", list);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView showAddUserPage() {
		return new ModelAndView("addUser", "userForm", new UserForm());
	}

	@RequestMapping(value = "/addUserProcess", method = RequestMethod.POST)
	public ModelAndView addUserProcess(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result) {
		System.out.println("Add Process starts ");
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("addUser");
			mav.addObject("userForm", userForm);
			return mav;
		}
		User user = new User();
		user.setUser_name(userForm.getName());
		user.setUser_username(userForm.getUsername());
		user.setUser_password(userForm.getPassword());
		user.setUser_contactno(userForm.getContactno());
		userDao.addUser(user);
		System.out.println("Added user ");
		return new ModelAndView("/addUserSuccess", "msg", "successfuly added user");

	}

	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") int userId) {
		System.out.println("delete user" + userId);
		User user = new User();
		user.setUser_id(userId);
		userDao.deleteUser(user);
		System.out.println("deleted");
		return "redirect:/showList";

	}

	@RequestMapping(value = "/editUser/{userId}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("userId") int userId) {
		System.out.println("edit user" + userId);

		User user = userDao.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		System.out.println("editing");
		UserForm userForm = new UserForm();
		userForm.setUserid(user.getUser_id());
		userForm.setName(user.getUser_name());
		userForm.setUsername(user.getUser_username());
		userForm.setPassword(user.getUser_password());
		userForm.setContactno(user.getUser_contactno());
		return new ModelAndView("editUser", "userForm", userForm);

	}

	@RequestMapping(value = "/editUserProcess", method = RequestMethod.POST)
	public ModelAndView editUserProcess(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult result) {
		System.out.println("Edit Process starts ");
		if (result.hasErrors()) {
			ModelAndView mav = new ModelAndView("editUser");
			mav.addObject("userForm", userForm);
			return mav;
		}
		User user = userDao.getUser(userForm.getUserid());
		user.setUser_name(userForm.getName());
		user.setUser_username(userForm.getUsername());
		user.setUser_password(userForm.getPassword());
		user.setUser_contactno(userForm.getContactno());
		userDao.addUser(user);
		System.out.println("Updated user ");
		return new ModelAndView("/addUserSuccess", "msg", "successfuly updated user");

	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, String> model = new HashMap<String, String>();
		model.put("exception", ex.toString());
		return new ModelAndView("addUserSuccess", model);

	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	public ModelAndView showInsertUserPage() {
		return new ModelAndView("insertUser", "userForm", new UserForm());
	}

	@RequestMapping(value = "/saveUser", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody UserJSONResponse saveUserUsingAjax(@ModelAttribute("userForm") @Valid UserForm userForm,
			BindingResult result) {
		System.out.println("Entered here" + userForm.getName());
		UserJSONResponse response = new UserJSONResponse();
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			response.setValidated(false);
			response.setErrorMessages(errors);
		} else {
			response.setValidated(true);
			response.setUserForm(userForm);
		}
		System.out.println(response.isValidated());
		return response;

	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public ModelAndView showFileUploadPage() {
		return new ModelAndView("fileUpload");
	}

	@RequestMapping(value = "/uploadFileProcess", method = RequestMethod.POST)
	public ModelAndView uploadFileProcess(HttpServletRequest request, @RequestParam CommonsMultipartFile[] uploadFile)
			throws Exception {
		if (uploadFile != null && uploadFile.length > 0) {
			System.out.println("Uploading goes here");
			for (CommonsMultipartFile aFile : uploadFile) {
				System.out.println("Uploading goes here" + aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")){
					//aFile.transferTo(new File(loc + aFile.getOriginalFilename()));// used to copy a file to alocation
				
					//to save to db
					UploadFile file = new UploadFile();
					file.setFile_name(aFile.getOriginalFilename());
					file.setFile_data(aFile.getBytes());
					userDao.saveFile(file);
				}
			}

			
		}
		return new ModelAndView("result", "msg", "File Uploaded Succesfully");

	}

	
	@RequestMapping(value="/customerRegistration",method=RequestMethod.GET)
	public ModelAndView showCustomerRegistration(){
		return new ModelAndView("customerRegistration","customerForm",new CustomerForm());
		
	}
	
	@RequestMapping(value="/processCustomerRegistration",method=RequestMethod.POST)
	public ModelAndView processCustomerRegistration(@ModelAttribute("customerForm") @Valid CustomerForm customerForm,BindingResult result){
		
		System.out.println("Processing goes here");
		if(result.hasErrors()){
			return new ModelAndView("customerRegistration","customerForm",customerForm);
		}
		Customer customer= createCustomerEntity(customerForm);
		
		System.out.println("Added customer ");
		return new ModelAndView("/addUserSuccess", "msg", "successfuly added customer");
	}

	public Customer createCustomerEntity(CustomerForm customerForm) {
		Customer customer= new Customer();
	//	customer.set
		return customer;
	}
	
	@ModelAttribute("countryList")
	public List<Country> getCountryList(){
		
		List<Country>  ctryList = new ArrayList<Country>();
		ctryList=userDao.getCountryList();
		 
		return ctryList;
	}

	//controller method to get relevantcity
	@RequestMapping(value="/getCities",method=RequestMethod.GET)
	public @ResponseBody List<City> getCities(@RequestParam("countryId") String countryId){
		System.out.println("here");
	    return userDao.retrieveCities(Integer.parseInt(countryId));
	}
}
