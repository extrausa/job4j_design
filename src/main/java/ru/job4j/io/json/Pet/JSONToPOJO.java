package ru.job4j.io.json.Pet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.io.json.Contact;
import ru.job4j.io.json.Person;

import java.util.ArrayList;
import java.util.List;

public class JSONToPOJO {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonOwnerCard = new JSONObject(
                "{\"ownerCard\":"
                            + "{"
                                + "\"name\":\"Bob\","
                                + "\"phone\":\"125-129\""
                            + "}"
                        + "}");

        List<String> list = new ArrayList<>();
        list.add("Jack");
        list.add("Tifany");
        JSONArray jsonStatuses = new JSONArray(list);

        final Pet pet = new Pet(true, 5, "Patrick",
                new OwnerCard("Jack", "123-123"),
                "Rick", "Mortilda");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", pet.isPuppy());
        jsonObject.put("age", pet.getAge());
        jsonObject.put("contact", jsonOwnerCard);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(pet).toString());
    }

}
