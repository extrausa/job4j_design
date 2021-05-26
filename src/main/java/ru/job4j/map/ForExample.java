package ru.job4j.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ForExample {
    public HashMap<Integer, String[]> clear(HashMap<Integer, String[]> maps) {
        HashMap<Integer, String[]> tempo = new HashMap<>();
        return tempo;
    }

    public static void main(String[] args) {
        ForExample test = new ForExample();
        HashMap<Integer, String[]> graph = new HashMap<Integer, String[]>();
        Integer user1, user2, user3, user4, user5;
        user1 = 1;
        user2 = 2;
        user3 = 3;
        user4 = 4;
        user5 = 5;

        String[] email1 = new String[]{"xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"};
        String[] email2 = new String[]{"foo@gmail.com", "ups@pisem.net"};
        String[] email3 = new String[]{"xyz@pisem.net", "vasya@pupkin.com"};
        String[] email4 = new String[]{"ups@pisem.net", "aaa@bbb.ru"};
        String[] email5 = new String[]{"xyz@pisem.net"};
        graph.put(user1, email1);
        graph.put(user2, email2);
        graph.put(user3, email3);
        graph.put(user4, email4);
        graph.put(user5, email5);
        for (String[] a : graph.values()) {
            System.out.println(Arrays.stream(a)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        }

        graph = test.clear(graph);

        for (String[] a : graph.values()) {
            System.out.println(Arrays.stream(a)
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));

        }


    }
}


