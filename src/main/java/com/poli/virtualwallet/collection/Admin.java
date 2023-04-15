package com.poli.virtualwallet.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document(collection="admin")
public class Admin {
    //atributos
    @Id
    private String id;
    private String email;

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id.equals(admin.id) && email.equals(admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }
}
