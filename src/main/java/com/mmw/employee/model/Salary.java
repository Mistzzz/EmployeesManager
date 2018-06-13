package com.mmw.employee.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DB_SALARY")
public class Salary implements Serializable {

    private static final long serialVersionUID = -3465813074586302842L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private BigDecimal salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateTo;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
//    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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

//    public Employee getEmployee() {
//        return employee;
//    }

//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary1 = (Salary) o;
        return id == salary1.id &&
                Objects.equals(salary, salary1.salary) &&
                Objects.equals(dateFrom, salary1.dateFrom) &&
                Objects.equals(dateTo, salary1.dateTo);
//                Objects.equals(employee, salary1.employee);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, salary, dateFrom, dateTo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Salary{");
        sb.append("id=").append(id);
        sb.append(", salary=").append(salary);
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append('}');
        return sb.toString();
    }
}
