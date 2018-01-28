package com.myspringpacks.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.valang.ValangValidator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.google.gson.Gson;
import com.myspringpacks.dao.CntryDAO;
import com.myspringpacks.dao.UserDAO;
import com.myspringpacks.entity.AhmForm;
import com.myspringpacks.entity.HawbForm;
import com.myspringpacks.entity.MultiFileModel;
import com.myspringpacks.entity.CustomerForm;
import com.myspringpacks.entity.FileModel;
import com.myspringpacks.entity.FileUploadDTO;
import com.myspringpacks.entity.UserForm;
import com.myspringpacks.exception.UserNotFoundException;
import com.myspringpacks.json.UserJSONResponse;
import com.myspringpacks.model.Ahm;
import com.myspringpacks.model.City;
import com.myspringpacks.model.Customer;
import com.myspringpacks.model.Fhl;
import com.myspringpacks.model.Hawbs;
import com.myspringpacks.model.Hdr;
import com.myspringpacks.model.UploadFile;
import com.myspringpacks.model.User;
import com.myspringpacks.validator.CustomerValidator;
import com.myspringpacks.validator.MultipleFileValidator;
import com.myspringpacks.validator.UserValidataor;

@Controller
@SessionAttributes("ahm")
public class ListController {

	private String loc = "D:/uploads/";

	@Autowired
	private UserDAO userDao;

	@Autowired
	private CntryDAO cntryDao;

	@Autowired
	private UserValidataor userValidator;

	@Autowired
	private CustomerValidator customerValidator;

	@Autowired
	private MultipleFileValidator multipleFileValidator;
	
	@Autowired
	@Qualifier("fileValidationList")
	ValangValidator fileValidationList;

	@ModelAttribute
	public MultiFileModel multiFileModel() {
		return new MultiFileModel(3);
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		// binder.addValidators(userValidator);
		// binder.addValidators(customerValidator);
	//	binder.setValidator(multipleFileValidator);
	}

	@RequestMapping(value = "/showList/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = (pageid - 1) * total + 1;
		}
		List<User> list = userDao.getUsersByPage(pageid, total);

		return new ModelAndView("list", "list", list);
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

	@RequestMapping(value = "/uploadProcess", method = RequestMethod.POST)
	public String handleFormUpload(@Valid MultiFileModel models, BindingResult result, RedirectAttributes redirectMap)
			throws IOException {

		if (result.hasErrors()) {
			return "multiplefileUpload";
		}

		String[] files = new String[models.getFiles().size()];
		int index = 0;
		for (FileModel model : models.getFiles()) {
			MultipartFile file = model.getFile();
			InputStream in = file.getInputStream();
			File destination = new File("/tmp/" + file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(in, destination);

			files[index] = file.getOriginalFilename();
			index++;
		}

		redirectMap.addFlashAttribute("filenames", files);

		return "redirect:success";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handleUserNotFoundException(UserNotFoundException ex) {
		Map<String, String> model = new HashMap<String, String>();
		model.put("exception", ex.toString());
		return new ModelAndView("addUserSuccess", model);

	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success() {
		return "success";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		return "error";
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

	@RequestMapping(value = "/uploadFHL", method = RequestMethod.GET)
	public ModelAndView showUploadFHLPage() {
		return new ModelAndView("uploadFHL");
	}


	@RequestMapping(value = "/uploadAttachment.json", method = RequestMethod.POST, headers = {
			"Accept=text/xml, application/json" }, produces = "application/json")
	public @ResponseBody List addAttachment(MultipartHttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		System.out.println("Enetered----------------");
		List<FileUploadDTO> errorFilesList = new ArrayList<FileUploadDTO>();
		List<FileUploadDTO> correctFilesList = new ArrayList<FileUploadDTO>();
		List <String>resultList = new ArrayList<String>();
		
		//file.getSize() > 100000 check for 10MB
		Double totalFileSize=0.0;
		int totalNoOfFilesPerUpload=0;
		List<Errors> systemErrors= validateFiles(request.getMultiFileMap().get("multipartFile"));
		if(systemErrors!= null && !systemErrors.isEmpty()){
			resultList.add("SystemError");
			for(ObjectError error:systemErrors.get(0).getAllErrors()){
				resultList.add(error.getDefaultMessage());
			}
			
		}else{
		for (MultipartFile file : request.getMultiFileMap().get("multipartFile")) {
			FileUploadDTO fileUploadDTO = new FileUploadDTO();
			 System.out.println("here-----------" + file.getName()); 
			 fileUploadDTO = new FileUploadDTO();
			 fileUploadDTO.setFileName(file.getOriginalFilename());
			 fileUploadDTO.setFileFormat(file.getContentType());
			 
			 Double size= (double) (file.getSize()/1024);
			 fileUploadDTO.setFileSize(size); 
			 
			// totalFileSize= totalFileSize+size;
			// fileUploadDTO.setTotalFileSize(totalFileSize);
			 
			// totalNoOfFilesPerUpload++;
			 //fileUploadDTO.setTotalNoOfFilesPerUpload(totalNoOfFilesPerUpload);
			 
			 
			 Errors fileErrors= new BeanPropertyBindingResult(fileUploadDTO, "fileUploadDTO");
			 fileValidationList.validate(fileUploadDTO, fileErrors);
			 System.out.println("errors-----------"+fileErrors );
			 if(fileErrors.hasErrors()){//haserrors check goes here
				
				 fileUploadDTO.setErrorList(fileErrors.getAllErrors().get(0).getDefaultMessage());
				 errorFilesList.add(fileUploadDTO);
				
			 }else{
				 correctFilesList.add(fileUploadDTO);
				// call uploadFunction here
				
				
			 }
		}
		
		 System.out.println("Error Files-----------" +errorFilesList.size());
		 System.out.println("Correct Files-----------" +correctFilesList.size());
		String str = "UploadedFinally";
		
		 
		 resultList.add("FileError");
		 resultList.add(errorFilesList.size()+"");
		 resultList.add(correctFilesList.size()+"");
		 for(FileUploadDTO errorFile:errorFilesList){
			 resultList.add(errorFile.getFileName()+":"+errorFile.getErrorList());
		 }
		}
		return resultList;

	}

	private List<Errors> validateFiles(List<MultipartFile> list) {
		int configTotalNoOFilesPerUpload=10;
		List<Errors> errorList=new ArrayList<Errors>();
		Double totalFileSize=0.0;
		if(list!= null && !list.isEmpty()){
			int size=list.size();
			FileUploadDTO fileUploadDTO= new FileUploadDTO();
			fileUploadDTO.setTotalNoOfFilesPerUpload(size);
			Double configFileSize=(double) 1;
			for (MultipartFile file : list) {
				double sizeOfFile= file.getSize();
				double kilobytes = sizeOfFile / 1024;
				double megabytes = kilobytes/1024;
				totalFileSize= totalFileSize+megabytes;
			}
			if(totalFileSize> configFileSize){
				System.out.println("Total size of all files greater than 3");
			}
			fileUploadDTO.setTotalFileSize(totalFileSize);
			Errors fileErrors= new BeanPropertyBindingResult(fileUploadDTO, "fileUploadDTO");
			fileValidationList.validate(fileUploadDTO, fileErrors);
			errorList.add(fileErrors);	 
		}
		
		return errorList;
	}

	@RequestMapping(value = "/multipleFileUpload", method = RequestMethod.GET)
	public ModelAndView showMultipleFileUploadPage() {
		return new ModelAndView("multiplefileUpload");
	}

	@RequestMapping(value = "/uploadFileProcess", method = RequestMethod.POST)
	public ModelAndView uploadFileProcess(HttpServletRequest request, @RequestParam CommonsMultipartFile[] uploadFile)
			throws Exception {
		if (uploadFile != null && uploadFile.length > 0) {
			System.out.println("Uploading goes here");
			for (CommonsMultipartFile aFile : uploadFile) {
				System.out.println("Uploading goes here" + aFile.getOriginalFilename());
				if (!aFile.getOriginalFilename().equals("")) {
					// aFile.transferTo(new File(loc +
					// aFile.getOriginalFilename()));// used to copy a file to
					// alocation

					// to save to db
					UploadFile file = new UploadFile();
					file.setFile_name(aFile.getOriginalFilename());
					file.setFile_data(aFile.getBytes());
					userDao.saveFile(file);
				}
			}

		}
		return new ModelAndView("result", "msg", "File Uploaded Succesfully");

	}

	@RequestMapping(value = "/customerRegistration", method = RequestMethod.GET)
	public ModelAndView showCustomerRegistration() {
		return new ModelAndView("customerRegistration", "customerForm", new CustomerForm());

	}

	@RequestMapping(value = "/processCustomerRegistration", method = RequestMethod.POST)
	public ModelAndView processCustomerRegistration(@ModelAttribute("customerForm") @Valid CustomerForm customerForm,
			BindingResult result) {

		System.out.println("Processing goes here");
		if (result.hasErrors()) {
			return new ModelAndView("customerRegistration", "customerForm", customerForm);
		}
		Customer customer = createCustomerEntity(customerForm);

		System.out.println("Added customer ");
		return new ModelAndView("/addUserSuccess", "msg", "successfuly added customer");
	}

	public Customer createCustomerEntity(CustomerForm customerForm) {
		Customer customer = new Customer();
		// customer.set
		return customer;
	}

	/*
	 * @ModelAttribute("countryList") public List<Country> getCountryList() {
	 * 
	 * List<Country> ctryList = new ArrayList<Country>(); ctryList =
	 * userDao.getCountryList();
	 * 
	 * return ctryList; }
	 */
	// controller method to get relevantcity
	@RequestMapping(value = "/getCities", method = RequestMethod.GET)
	public @ResponseBody List<City> getCities(@RequestParam("countryId") String countryId) {
		System.out.println("here");
		List<City> list = userDao.retrieveCities(Integer.parseInt(countryId));
		System.out.println(list);
		return list;
	}

	@RequestMapping(value = "/search")
	public ModelAndView Search(@RequestParam(value = "searchString", required = false) String pSearchTerm,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("searchTerm", pSearchTerm);
		List<User> list;
		list = userDao.findUser(pSearchTerm);
		System.out.println("pSearchTerm " + pSearchTerm);
		System.out.println(list.get(0).getUser_name());
		mav.addObject("list", list);

		return mav;
	}

	// SubmitAHM.jsp

	@RequestMapping(value = "/submitAhm", method = RequestMethod.GET)
	public ModelAndView showSubmitAhmPage() {
		cntryDao.showData();
		return new ModelAndView("submitAhm", "ahmForm", new AhmForm());
	}

	@RequestMapping(value = "/showHawbList", method = RequestMethod.GET)
	public ModelAndView showHawbList(HttpSession session, ModelMap modelMap) {
		System.out.println("--------------eneteerd------------------- ");
		modelMap = new ModelMap();
		List<Hawbs> hawbList = new ArrayList<Hawbs>();
		Ahm ahm = null;
		if (session != null) {
			ahm = (Ahm) session.getAttribute("Ahm");
		}
		System.out.println("--------------Ahm------------------- " + ahm.getCra_ahm_detail_stg_id());
		if (hawbList != null && hawbList.isEmpty()) {
			if (ahm != null) {
				hawbList = userDao.getHawbList(ahm);
			}
		}
		System.out.println("--------------List------------------- " + hawbList.get(0).getCra_hawb_detail_stg_id());
		// modelMap.addAttribute("hawbList", hawbList);
		// return new ModelAndView("showList");
		return new ModelAndView("showList", "hawbList", hawbList);
	}

	@RequestMapping(value = "/submitAhmProcess", method = RequestMethod.POST)
	public ModelAndView submitAhmProcess(@ModelAttribute("ahmForm") AhmForm ahmForm, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, ModelMap modelMap) {

		/*System.out.println("Adding AHM starts here");
		Ahm ahm = new Ahm();
		ahm.setCmn_ref_transaction_type_id(6);
		ahm.setMawb_number(ahmForm.getMawbno());
		ahm.setNoofpieces(ahmForm.getNoofpieces());
		ahm.setWeight(ahmForm.getWeight());

		//finding mawbno sum 
		//int cnt  = userDao.findCount(ahmForm.getMawbno());
		int ahmId = 0;
		if (ahm != null)
			ahmId = userDao.addAhm(ahm);
		System.out.println("Ahm id:" + ahmId);
		session.setAttribute("Ahm", ahm);*/
		System.out.println("Send Email Code starts here");
		
		//CRAFHLHeader is Hdr
		//CRAAHMDetailStg is Ahm
		List<Ahm> ahmList=null;
		List<Integer> parentAhmIdList=new ArrayList<Integer>();
		List<Hdr> submittedFHLList=userDao.fetchFHLList();
		
		/*if(submittedFHLList !=null && !submittedFHLList.isEmpty()){
			for(Hdr fhl:submittedFHLList){
				if(!parentAhmIdList.contains(fhl.getParentAhmId())){
					parentAhmIdList.add(fhl.getParentAhmId());
				}
			}
		}*/
		parentAhmIdList= userDao.fetchParentIdList();
		
		if(parentAhmIdList!=null && !parentAhmIdList.isEmpty()){
			//parentAhmIdList= removeDuplicates(parentAhmIdList);
			//ahmList= userDao.getAhmDtlStgByParentAhmId(parentAhmIdList);
		}
		Map<Integer,List<Integer>> parentAhmFHLMap=frameMap(parentAhmIdList,submittedFHLList);
		if(ahmList!=null && !ahmList.isEmpty()){
			for(Ahm ahm:ahmList){
				if(ahm.getMawb_number()!=null){
					if(sendEmail(ahm.getMawb_number())){
						updateFHLMailStatus(ahm.getParentAhmId(),parentAhmFHLMap);
					}
				}
			}
		}
		return new ModelAndView("/addUserSuccess", "msg", "AHM saved in draft");

	}

	private Map<Integer, List<Integer>> frameMap(List<Integer> parentAhmIdList, List<Hdr> submittedFHLList) {
		Map<Integer,List<Integer>> parentAhmFHLMap= new HashMap<Integer,List<Integer>>();
		
		if(parentAhmIdList!=null && !parentAhmIdList.isEmpty()){
			for(Integer parentAhmId:parentAhmIdList){
				
					List<Integer> fhlIds=new ArrayList<Integer>();
					for(Hdr fhl:submittedFHLList){
						if(fhl.getParentAhmId()==parentAhmId){
							fhlIds.add(fhl.getCra_fhl_upload_header_id());
						}
					}
					parentAhmFHLMap.put(parentAhmId,fhlIds);
				
			}
		}
		return parentAhmFHLMap;
	}

	private void updateFHLMailStatus(int parentAhmId,Map<Integer,List<Integer>> parentAhmFHLMap) {
		if(parentAhmId!=0){
			if(parentAhmFHLMap!=null &&!parentAhmFHLMap.isEmpty()){
				Iterator<Map.Entry<Integer,List<Integer>>> itr1 = parentAhmFHLMap.entrySet().iterator();
				while(itr1.hasNext()) {
				    Map.Entry<Integer,List<Integer>> entry = itr1.next();
				    if(entry.getKey().equals(parentAhmId)){
				    	List<Integer> fhlList= entry.getValue();
				    	userDao.updateFHLMailStatus(fhlList);
				    }
				}
			}
		}
		
		
	}

	private Boolean sendEmail(String mawb_number) {
		Boolean mailSent=false;
		if(mawb_number!=null){
			System.out.println("Send Email"+mawb_number);
			mailSent=true;
		}
		return mailSent;
		
	}

	private List<Integer> removeDuplicates(List<Integer> parentAhmIdList) {
		// TODO Auto-generated method stub
		return parentAhmIdList;
	}

	@RequestMapping(value = "/addHawb", method = RequestMethod.GET)
	public ModelAndView showAddHawbPage(HttpSession session) {

		if (session != null) {
			Ahm ahm = (Ahm) session.getAttribute("Ahm");
			System.out.println("------------Ahm goes here-----------" + ahm.getCra_ahm_detail_stg_id());
		}
		return new ModelAndView("addHawb", "hawbForm", new HawbForm());
	}

	@RequestMapping(value = "/submitHawbProcess", method = RequestMethod.POST)
	public ModelAndView submitHawbProcess(@ModelAttribute("hawbForm") HawbForm hawbForm, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, ModelMap modelMap) {

		System.out.println("--------------Add Hawb Process goes here----------------");
		Hawbs hawb = new Hawbs();
		hawb.setGoods_description(hawbForm.getGoods_description());
		hawb.setHawb_number(hawbForm.getHawbno());
		hawb.setHawb_weight(hawbForm.getWeight());
		hawb.setHawb_noofpieces(hawbForm.getNoofpieces());
		// Todo
		if (session != null) {
			Ahm ahm = (Ahm) session.getAttribute("Ahm");
			hawb.setCra_ahm_detail_stg_id(ahm.getCra_ahm_detail_stg_id());
			hawb.setMawb_number(ahm.getMawb_number());
		}

		hawb.setIsFile(false);
		// here set
		int hawbId = 0;
		if (hawb != null)
			hawbId = userDao.addHawb(hawb);
		System.out.println("Hawb id:" + hawbId);

		return new ModelAndView("/addUserSuccess", "msg", "Hawb saved in db");
	}

	@RequestMapping(value = "/uploadHawb", method = RequestMethod.GET)
	public ModelAndView showUploadHawbPage() {
		return new ModelAndView("uploadHawb");
	}

	@RequestMapping(value = "/uploadHawbFileProcess", method = RequestMethod.POST)
	public ModelAndView uploadHawbFileProcess(HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] uploadFile, HttpSession session) {
		int fhlId = 0;
		// todo fhl.setCra_ahm_detail_stg_id(cra_ahm_detail_stg_id);
		if (uploadFile != null && uploadFile.length > 0) {
			for (CommonsMultipartFile aFile : uploadFile) {
				if (!aFile.getOriginalFilename().equals("")) {
					Fhl fhl = new Fhl();
					fhl.setFilename(aFile.getOriginalFilename());
					fhl.setFile_data(aFile.getBytes());
					if (session != null) {
						Ahm ahm = (Ahm) session.getAttribute("Ahm");

						fhl.setCra_ahm_detail_stg_id(ahm.getCra_ahm_detail_stg_id());
						fhl.setMawb_number(ahm.getMawb_number());
					}
					if (fhl != null) {
						System.out.println("--------------Adding to FHLtable----------------");
						fhlId = userDao.addFhl(fhl);
					}
					System.out.println("Fhl id:" + fhlId);
					if (fhlId != 0) {

						System.out.println("shows fhl entry created" + fhlId);

						System.out.println("addingto hawb table starts here" + fhlId);
						Hawbs hawb = new Hawbs();
						if (session != null) {
							Ahm ahm = (Ahm) session.getAttribute("Ahm");
							hawb.setCra_ahm_detail_stg_id(ahm.getCra_ahm_detail_stg_id());
							hawb.setMawb_number(ahm.getMawb_number());
							hawb.setCra_fhl_upload_detail_id(fhlId);
						}
						hawb.setIsFile(true);
						hawb.setDocStatus("Uploaded");
						int hawbId = 0;
						if (hawb != null)
							hawbId = userDao.addHawb(hawb);
						System.out.println("Hawb id added for fhl entry" + hawbId);
					}
				}
			}
		}

		return new ModelAndView("/addUserSuccess", "msg", "File uploaded and saved in db");
	}

	// deleteHawb/${hawb.cra_hawb_detail_stg_id}
	@RequestMapping(value = "/deleteHawb/{hawbId}", method = RequestMethod.GET)
	public String deleteHawb(@PathVariable("hawbId") int hawbId, HttpSession session) {
		Ahm ahm = null;
		if (session != null) {
			ahm = (Ahm) session.getAttribute("Ahm");
			System.out.println(ahm);
		}
		System.out.println("delete hawbId" + hawbId);
		List<Hawbs> fhlList = new ArrayList<Hawbs>();
		List<Hawbs> hawbList = new ArrayList<Hawbs>();
		List<Hawbs> hawbListToBeDeleted = new ArrayList<Hawbs>();
		Hawbs hawbs = userDao.getHawb(hawbId);
		hawbListToBeDeleted.add(hawbs);
		if (hawbListToBeDeleted != null && !hawbListToBeDeleted.isEmpty()) {
			for (Hawbs hawb : hawbListToBeDeleted) {
				if ((hawb.getIsFile()) && !(StringUtils.isEmpty(hawb.getDocStatus()))
						&& !(hawb.getDocStatus().equals("Uploaded"))) {
					fhlList.add(hawb);
				} else {
					hawbList.add(hawb);
				}
			}
		}
		if (!(fhlList.isEmpty())) {
			// perform fhl deletion
			userDao.deleteAllFhl(fhlList);

		}
		if (!(hawbList.isEmpty())) {
			// perform hawbstg deletion
			userDao.deleteAllHawb(hawbList);
		}
		System.out.println("deleted");
		if (ahm != null) {
			session.setAttribute("Ahm", ahm);
		}
		return "redirect:/showHawbList";

	}

	@RequestMapping(value = "/deleteAllHawb", method = RequestMethod.GET)
	public String deleteAllHawb(HttpSession session) {
		Ahm ahm = null;
		if (session != null) {
			ahm = (Ahm) session.getAttribute("Ahm");
			System.out.println("goes here ---------------------" + ahm);
		}
		List<Hawbs> fhlList = new ArrayList<Hawbs>();
		List<Hawbs> hawbList = new ArrayList<Hawbs>();
		List<Hawbs> hawbListToBeDeleted = new ArrayList<Hawbs>();

		System.out.println("--------------Ahm------------------- " + ahm.getCra_ahm_detail_stg_id());
		if (hawbListToBeDeleted != null && hawbListToBeDeleted.isEmpty()) {
			if (ahm != null) {
				hawbListToBeDeleted = userDao.getHawbList(ahm);
			}
		}
		if (hawbListToBeDeleted != null && !hawbListToBeDeleted.isEmpty()) {
			for (Hawbs hawb : hawbListToBeDeleted) {
				if ((hawb.getIsFile()) && !(StringUtils.isEmpty(hawb.getDocStatus()))
						&& !(hawb.getDocStatus().equals("Uploaded"))) {
					fhlList.add(hawb);
				} else {
					hawbList.add(hawb);
				}
			}
		}
		if (!(fhlList.isEmpty())) {
			// perform fhl deletion
			userDao.deleteAllFhl(fhlList);
		}
		if (!(hawbList.isEmpty())) {
			// perform hawbstg deletion
			userDao.deleteAllHawb(hawbList);
		}

		System.out.println("deleted");

		return "redirect:/showHawbList";

	}

}
