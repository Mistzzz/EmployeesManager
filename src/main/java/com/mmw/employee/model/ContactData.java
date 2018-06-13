package com.mmw.employee.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DB_CONTACT")
public class ContactData implements Serializable {

    private static final long serialVersionUID = -3465813074586302843L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Set<Email> emails;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Set<Phone> phones;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Set<Address> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(emails, that.emails) &&
                Objects.equals(phones, that.phones) &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, emails, phones, addresses);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactData{");
        sb.append("id=").append(id);
        sb.append(", emails=").append(emails);
        sb.append(", phones=").append(phones);
        sb.append(", addresses=").append(addresses);
        sb.append('}');
        return sb.toString();
    }
}
