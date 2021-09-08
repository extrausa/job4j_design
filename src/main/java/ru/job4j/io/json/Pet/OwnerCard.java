package ru.job4j.io.json.Pet;

public class OwnerCard {
    private final String name;
    private final String phone;

    public OwnerCard(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "OwnerCard{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }
}
