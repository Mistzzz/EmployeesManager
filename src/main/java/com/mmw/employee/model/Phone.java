package com.mmw.employee.model;

import com.mmw.employee.model.enums.PhoneType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "DB_PHONE", uniqueConstraints = @UniqueConstraint(columnNames = {"type", "value"}))
public class Phone implements Serializable {

    private static final long serialVersionUID = -3465813074586302844L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id == phone.id &&
                type == phone.type &&
                Objects.equals(value, phone.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
