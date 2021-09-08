package ru.job4j.io.json.Pet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InOutJSON {
    public static void main(String[] args) {
        final Pet pet = new Pet(true, 5, "Patrick",
                new OwnerCard("Jack", "123-123"),
                "Rick", "Mortilda");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(pet));

        final String petJson =
                "{"
                    + "\"puppy\":false,"
                    + "\"age\":13,"
                    + "\"nickname\":\"Cash\","
                    + "\"ownerCard\":"
                    + "{"
                            + "\"name\":\"Bob\","
                            + "\"phone\":\"125-129\""
                    + "},"
                    + "\"parents\":"
                        + "[\"Chip\",\"Dalesha\"]"
                + "}";
        final Pet petMod = gson.fromJson(petJson, Pet.class);
        System.out.println(petMod);
    }
}
