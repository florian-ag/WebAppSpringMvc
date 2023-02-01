package fr.formation.inti.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.inti.dao.EmployeeServiceImpl;
import fr.formation.inti.model.Employee;

@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private EmployeeServiceImpl serviceEmployee;

	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		logger.info("Welcome");
//		model.addAttribute("title", "Welcome");
//		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		logger.info("Admin");
		return "adminPage";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(Model model) {
		logger.info("Employee");
		List<Employee> list = (List<Employee>) serviceEmployee.findAll();
		model.addAttribute("list", list);
		System.out.println(list);
		return "employee";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmployee(Model model, @RequestParam Integer id) {
		logger.info("Delete");
		serviceEmployee.deleteById(id);
		List<Employee> list = (List<Employee>) serviceEmployee.findAll();
		model.addAttribute("list", list);
		return "/employee";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String editEmployeeGet(Model model, @RequestParam Integer id) {
		logger.info("UpdateGet");
		Employee emp = serviceEmployee.findById(id).get();

		System.out.println(emp);
		System.out.println(id);
		model.addAttribute("emp", emp);
		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String editEmployeePost(@ModelAttribute("emp") @Validated Employee employee, BindingResult br, Model model,
			@RequestParam Integer id) {
		logger.info("UpdatePost");
		if (br.hasErrors()) {
			return "update";
		} else {
			Employee emp = serviceEmployee.findById(id).get();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setTitle(employee.getTitle());
			emp.setStartDate(employee.getStartDate());
			serviceEmployee.saveOrUpdate(employee);
			
			List<Employee> list = (List<Employee>) serviceEmployee.findAll();
			model.addAttribute("list", list);
			return "/employee";
		}
	}

	@ModelAttribute("add")
	public Employee createEmployeeModel() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new Employee();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployeeGet() {
		logger.info("addGet");
		return "add";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployeePost(@ModelAttribute("add") @Validated Employee employee, BindingResult br, Model model) {
		logger.info("addPost");
		if (br.hasErrors()) {
			return "add";
		} else {
			Employee emp = new Employee();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setTitle(employee.getTitle());
			emp.setStartDate(employee.getStartDate());
			serviceEmployee.saveOrUpdate(employee);
			
			List<Employee> list = (List<Employee>) serviceEmployee.findAll();
			model.addAttribute("list", list);
			return "/employee";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		logger.info("login");
		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// After user login successfully.
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		model.addAttribute("message", "Bonjour " + userName);
		return "userInfoPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}
}

