package com.mmw.employee.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DB_DEPARTMENT", uniqueConstraints = @UniqueConstraint(columnNames = {"signature"}))
public class Department implements Serializable {

    private static final long serialVersionUID = -3465813074586302842L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String name;
    private String signature;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City localization;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.department", cascade=CascadeType.ALL)
    Set<EmployeeDepartment> employeeDepartments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public City getLocalization() {
        return localization;
    }

    public void setLocalization(City localization) {
        this.localization = localization;
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
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(signature, that.signature) &&
                Objects.equals(localization, that.localization) &&
                Objects.equals(employeeDepartments, that.employeeDepartments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, signature, localization, employeeDepartments);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Department{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", localization=").append(localization);
        sb.append(", employee=").append(employeeDepartments);
        sb.append('}');
        return sb.toString();
    }
}
