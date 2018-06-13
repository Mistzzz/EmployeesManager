package com.mmw.employee.service;

import java.util.List;

import com.mmw.employee.dao.EmployeeDAO;
import com.mmw.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public Employee getEmployee(int empid) {
		return employeeDAO.getEmployee(empid);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
