package com.mmw.employee.model;

import com.mmw.employee.model.enums.GenderType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DB_EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = -3465813074586302841L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Set<Salary> salaries;

    @OneToOne()
    private ContactData contactData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.employee")
    Set<EmployeeDepartment> employeeDepartments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public Set<EmployeeDepartment> getEmployeeDepartments() {
        return employeeDepartments;
    }

    public void setEmployeeDepartments(Set<EmployeeDepartment> employeeDepartments) {
        this.employeeDepartments = employeeDepartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(hireDate, employee.hireDate) &&
                gender == employee.gender &&
                Objects.equals(salaries, employee.salaries) &&
                Objects.equals(contactData, employee.contactData) &&
                Objects.equals(employeeDepartments, employee.employeeDepartments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, birthDate, hireDate, gender, salaries, contactData, employeeDepartments);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", gender=").append(gender);
        sb.append(", salaries=").append(salaries);
        sb.append(", contactData=").append(contactData);
        sb.append(", departments=").append(employeeDepartments);
        sb.append('}');
        return sb.toString();
    }
}
