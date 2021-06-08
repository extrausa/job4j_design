package ru.job4j.map;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestIdeaTest {

    @Test
    public void whenEmail() {
        TestIdea testIdea = new TestIdea();
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
        //testIdea.merge();
    }

}