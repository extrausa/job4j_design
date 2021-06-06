package ru.job4j.map;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User{

    String name;
    Set<String> emails;

    public User(String name, Set<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}
