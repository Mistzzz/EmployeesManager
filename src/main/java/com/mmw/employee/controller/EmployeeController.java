package com.mmw.employee.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mmw.employee.model.Employee;
import com.mmw.employee.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/")
public class EmployeeController {

	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {

		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("homeForm");
		return model;
	}

	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {

		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("editEmployeeForm");
		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {

		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {

		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {

		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("editEmployeeForm");
		model.addObject("employee", employee);
		return model;
	}

	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
}