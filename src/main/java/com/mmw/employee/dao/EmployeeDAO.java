package com.mmw.employee.dao;

import java.util.List;
import com.mmw.employee.model.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee employee);

	List<Employee> getAllEmployees();

	void deleteEmployee(Integer employeeId);

	Employee updateEmployee(Employee employee);

	Employee getEmployee(int employeeId);
}
