package com.mmw.employee.model;

import com.mmw.employee.model.enums.AddressType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "DB_ADDRESS", uniqueConstraints = @UniqueConstraint(columnNames = {"type", "contact_id"}))
public class Address implements Serializable {

    private static final long serialVersionUID = -3465813074586302846L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Enumerated(EnumType.STRING)
    private AddressType type;

    private String line1;
    private String line2;

    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                Objects.equals(type, address.type) &&
                Objects.equals(line1, address.line1) &&
                Objects.equals(line2, address.line2) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, line1, line2, zipCode, city);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", line1='").append(line1).append('\'');
        sb.append(", line2='").append(line2).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city=").append(city);
        sb.append('}');
        return sb.toString();
    }
}
