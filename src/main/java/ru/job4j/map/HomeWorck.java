package ru.job4j.map;

import java.util.*;

public class HomeWorck {
    public void convert(List<User> source) {

        Map<String, User> emails = new HashMap<>(); //ключ - e-mail, значение - объект
        Map<User, User> dups = new HashMap<>(); //ключ - пользователь, значение - основной пользователь
        Set<User> unique = new HashSet<>(); // множество уникальных пользователей

        for (User user : source) {
            boolean isMainUser = true;  // Пока считаем, что пользователь основной
            for (String email : user.getEmails()) {
                User prevUser = emails.putIfAbsent(email, user);
                // Уже есть пользователь с таким e-mail
                if (prevUser != null) {
                    // достаем основного пользователя
                    prevUser = dups.getOrDefault(prevUser, prevUser);
                    prevUser.emails.addAll(user.emails); // добавляем основному пользователю свои адреса
                    dups.put(user, prevUser);
                    isMainUser = false;
                }
            }
            if (isMainUser) { // если все адреса были уникальными
                unique.add(user);
            }
        }

        for (User user: unique) {
            System.out.println(user.getName() + " " + user.getEmails());
        }

    }
    public static void main(String[] args) {
        HomeWorck email = new HomeWorck();
        List<User> source = Arrays.asList(
                new User("user1", new HashSet<String>(Arrays.asList(
                        "xxx@ya.ru",
                        "foo@gmail.com",
                        "lol@mail.ru"))),
                new User("user2", new HashSet<String>(Arrays.asList(
                        "foo@gmail.com",
                        "ups@pisem.net"))),
                new User("user3", new HashSet<String>(Arrays.asList(
                        "xyz@pisem.net",
                        "vasya@pupkin.com"))),
                new User("user4", new HashSet<String>(Arrays.asList(
                        "ups@pisem.net",
                        "aaa@bbb.ru"))),

                new User("user5", new HashSet<String>(Arrays.asList(
                        "xyz@pisem.net")))
        );
        email.convert(source);
    }


}
