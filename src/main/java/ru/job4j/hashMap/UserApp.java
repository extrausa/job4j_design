package ru.job4j.hashMap;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserApp {
    public static void main(String[] args) {

        User one = new User("Ivan", 4, (
                new GregorianCalendar(2012, 12, 12)));
        User two = new User("Ivan", 4, (
                new GregorianCalendar(2012, 12, 12)));

        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(one, new  Object());
        userObjectMap.put(two, new  Object());

        userObjectMap.entrySet().forEach(
                userObjectEntry -> System.out.println(userObjectEntry.getKey() + " " + userObjectEntry.getValue()));
    }
}




