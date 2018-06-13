package com.mmw.employee.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DB_EMPLOYEE_DEPARTMENT")
@AssociationOverrides({
        @AssociationOverride(name = "pk.employee",
                joinColumns = @JoinColumn(name = "employee_id")),
        @AssociationOverride(name = "pk.department",
                joinColumns = @JoinColumn(name = "department_id")) })
public class EmployeeDepartment implements Serializable {

    private static final long serialVersionUID = -3465813074586302839L;

    @EmbeddedId
    private EmployeeDepartmentId pk;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

    public EmployeeDepartmentId getPk() {
        return pk;
    }

    public void setPk(EmployeeDepartmentId pk) {
        this.pk = pk;
    }

    @Transient
    public Employee getEmployee() {
        return getPk().getEmployee();
    }

    public void setEmployee(Employee employee) {
        getPk().setEmployee(employee);
    }

    @Transient
    public Department getDepartment() {
        return getPk().getDepartment();
    }

    public void setDepartment(Department department) {
        getPk().setDepartment(department);
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
