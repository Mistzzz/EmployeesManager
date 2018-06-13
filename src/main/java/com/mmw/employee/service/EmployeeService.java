package com.mmw.employee.service;

import java.util.List;

import com.mmw.employee.model.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(Integer employeeId);

	Employee getEmployee(int employeeId);

	Employee updateEmployee(Employee employee);
}
