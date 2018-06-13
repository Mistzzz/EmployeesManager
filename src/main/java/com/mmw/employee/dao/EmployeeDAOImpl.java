package com.mmw.employee.dao;

import com.mmw.employee.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {

        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    public List<Employee> getAllEmployees() {

        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }

    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
}