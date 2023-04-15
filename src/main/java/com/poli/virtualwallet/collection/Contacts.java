package com.poli.virtualwallet.collection;

import lombok.Data;

import java.util.Objects;

@Data
public class Contacts {

private String email;
private String nickname;

    @Override
    public String toString() {
        return "Contactos{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contactos = (Contacts) o;
        return email.equals(contactos.email) && nickname.equals(contactos.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nickname);
    }
}
