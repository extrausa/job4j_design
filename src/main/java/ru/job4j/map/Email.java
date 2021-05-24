package ru.job4j.map;

import java.util.Arrays;
import java.util.Objects;

public class Email {
    private String[] email;

    public Email(String[] email) {
        this.email = email;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Arrays.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(email);
    }

    @Override
    public String toString() {
        return "Email{" +
                "email=" + Arrays.toString(email) +
                '}';
    }
}
