package ru.job4j.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ForExample {
    HashMap<Integer, String[]> vertexList = new HashMap<Integer, String[]>();
    private final int MAX_VERTS = 32;
    int[][] adjMat;
    private int nVerts; // текущее количество вершин

    public ForExample() {
        this.adjMat = new int[MAX_VERTS][MAX_VERTS];
        this.nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void adge(HashMap<Integer, String[]> forjob){
        for (Integer a: forjob.keySet()) {
            if (a.)

        }


    }

    public static void main(String[] args) {
        ForExample test = new ForExample();
        HashMap<Integer, String[]> allList = new HashMap<Integer, String[]>();
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
        allList.put(user1, email1);
        allList.put(user2, email2);
        allList.put(user3, email3);
        allList.put(user4, email4);
        allList.put(user5, email5);
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


