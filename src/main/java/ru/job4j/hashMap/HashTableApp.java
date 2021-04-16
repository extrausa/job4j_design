package ru.job4j.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem<Integer, String> aDataItem;
        int akey, size, n, keyPerCell;
        String word = "word";

        System.out.println("Enter size of hash table: ");

        //size = getInt();
        size = 10;

        System.out.println("Enter initial number of items: ");

        //n = getInt();
        n = 2;

        keyPerCell = 10;

        HashTable<Integer, String> theHashTable = new HashTable<>(size);

        for (int i = 0; i < n; i++) {
            akey = (int) (Math.random() * keyPerCell * size);
            aDataItem = new DataItem<Integer, String>(akey, word + i);
            theHashTable.insert(aDataItem);

        }
        theHashTable.displayTable();

        theHashTable.insert(4, "Hello");
        theHashTable.insert(44, "Hello");

        theHashTable.displayTable();
        theHashTable.delete(44);
        theHashTable.displayTable();

    }

    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
