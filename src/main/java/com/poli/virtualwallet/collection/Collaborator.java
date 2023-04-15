package com.poli.virtualwallet.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "collaborator")
public class Collaborator {
    //atributos
    @Id
    private String email;
    private String name;
    private Double balance;
    private List<Contacts> contactsList;
    private Boolean logged;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return email.equals(that.email) && name.equals(that.name) && balance.equals(that.balance) && contactsList.equals(that.contactsList) && logged.equals(that.logged);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, balance, contactsList, logged);
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", contactsList=" + contactsList +
                ", logged=" + logged +
                '}';
    }
}
