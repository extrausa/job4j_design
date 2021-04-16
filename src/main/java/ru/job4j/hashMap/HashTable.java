package ru.job4j.hashMap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashTable<K, V> implements Iterator<V> {
    private int arraySize;
    private int DEFAULT_CAPACITY = 16;
    private DataItem<K, V>[] hashArray;
    private int empty;
    private int counterArray = 0;
    private int valuesCounter = 0;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new DataItem[arraySize];
        this.empty = arraySize;
    }

    public HashTable() {
        this.hashArray = new DataItem[DEFAULT_CAPACITY];
        arraySize = DEFAULT_CAPACITY;
        this.empty = arraySize;
    }

    public void displayTable() {
        System.out.println("Table: ");

        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.println(hashArray[i].getKey() + " " + hashArray[i].getValue());
            } else {
                System.out.println("** ");
            }
        }
        System.out.println("");

    }

    public int hashFunk(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {

        int key = (int) item.getKey();
        int hasVal1 = hashFunk(key);
        while (hashArray[hasVal1] != null) {
            ++hasVal1;
            hasVal1 %= arraySize;
        }
        hashArray[hasVal1] = item;
        empty--;
    }

    public boolean insert(K key, V value) {
        arrayExtension();
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null && key.equals(hashArray[i].getKey())) {
                return false;
            }
        }
        int keyTemp = (int) key;
        int hasVal1 = hashFunk(keyTemp);
        while (hashArray[hasVal1] != null) {
            ++hasVal1;
            hasVal1 %= arraySize;
        }

        hashArray[hasVal1] = new DataItem<>(key, value);
        empty--;
        return true;
    }

    private void arrayExtension() {
        if (empty < arraySize / 2) {
            int newSize = arraySize * 2;
            hashArray = Arrays.copyOf(hashArray, newSize);
        }
    }

    public K get(K key) {
        for (int i = 0; i < arraySize; i++) {
            if (key.equals(hashArray[i].getKey())) {
                return key;
            }
        }

        return null;
    }

    public boolean delete(K key) {
        int hasVal = hashFunk((int) key);
        while (hashArray[hasVal] != null) {
            if (hashArray[hasVal].getKey() == key) {
                hashArray[hasVal] = null;
                return true;
            }
            ++hasVal;
            hasVal %= arraySize;
        }
        return false;
    }


    @Override
    public boolean hasNext() {
        if (valuesCounter == arraySize) {
            return false;
        }
        if (hashArray[valuesCounter] == null) {
            if (moveToNextCell()) {
                return true;
            } else {
                return false;
            }
        }

    }

    private boolean moveToNextCell() {
        counterArray++;
        while (counterArray < arraySize && hashArray[counterArray] == null) {
            counterArray++;
        }
        return  counterArray < arraySize && hashArray[counterArray] != null;
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        valuesCounter++;
        return hashArray[valuesCounter].getValue();

    }
}
