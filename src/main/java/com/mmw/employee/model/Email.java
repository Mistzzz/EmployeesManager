package com.mmw.employee.model;

import com.mmw.employee.model.enums.EmailType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "DB_EMAIL", uniqueConstraints = @UniqueConstraint(columnNames = {"type", "value"}))
public class Email implements Serializable {

    private static final long serialVersionUID = -3465813074586302845L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Enumerated(EnumType.STRING)
    private EmailType type;

    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
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
        Email email = (Email) o;
        return id == email.id &&
                type == email.type &&
                Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Email{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
