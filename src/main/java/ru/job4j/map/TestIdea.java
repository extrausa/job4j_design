package ru.job4j.map;

import java.util.*;

public class TestIdea {

    public Map<String, Set<String>> merge(Map<String, Set<String>> data) {
        Map<String, Set<String>> mapa = new HashMap<>();

        return mapa;
    }

    public static void main(String[] args) {
        TestIdea test = new TestIdea();
        Map<String, Set<String>> map = new HashMap<>() {
            {
                put("user1", new HashSet<>(Arrays.asList(
                        "xxx@ya.ru",
                        "foo@gmail.com",
                        "lol@mail.ru"
                )));
                put("user2", new HashSet<>(Arrays.asList(
                        "foo@gmail.com",
                        "ups@pisem.net"
                )));
                put("user3", new HashSet<>(Arrays.asList(
                        "xyz@pisem.net",
                        "vasya@pupkin.com"
                )));
                put("user4", new HashSet<>(Arrays.asList(
                        "ups@pisem.net",
                        "aaa@bbb.ru"
                )));
                put("user5", new HashSet<>(Arrays.asList(
                        "xyz@pisem.net"
                )));
            }
        };
        test.merge(map);
    }
}
