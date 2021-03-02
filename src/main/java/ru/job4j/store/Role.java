package ru.job4j.store;

public class Role extends Base {

    private String name;
    private int number;

    public Role(String id, String name, int number) {
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
