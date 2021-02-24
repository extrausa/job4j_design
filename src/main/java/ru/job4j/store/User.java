package ru.job4j.store;

public class User extends Base {
    private String name;
    private int number;

    public User(String id, String name, int number) {
        super(id);
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
