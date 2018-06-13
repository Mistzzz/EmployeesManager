package com.mmw.employee.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeDepartmentId implements Serializable {

    private static final long serialVersionUID = -3465813074586302840L;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDepartmentId that = (EmployeeDepartmentId) o;
        return Objects.equals(employee, that.employee) &&
                Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {

        return Objects.hash(employee, department);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDepartmentId{");
        sb.append("employee=").append(employee);
        sb.append(", department=").append(department);
        sb.append('}');
        return sb.toString();
    }
}
