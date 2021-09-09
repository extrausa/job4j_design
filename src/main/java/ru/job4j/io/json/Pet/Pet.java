package ru.job4j.io.json.Pet;

import java.util.Arrays;

public class Pet {
    private final boolean puppy;
    private final int age;
    private final String nickname;
    private final OwnerCard ownerCard;
    private final String[] parents;

    public Pet(boolean puppy, int age, String nickname, OwnerCard ownerCard, String... parents) {
        this.puppy = puppy;
        this.age = age;
        this.nickname = nickname;
        this.ownerCard = ownerCard;
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Pet{" + "puppy=" + puppy + ", age=" + age + ", nickname='" + nickname + '\'' + ", ownerCard=" + ownerCard + ", parents=" + Arrays.toString(parents) + '}';
    }
}
