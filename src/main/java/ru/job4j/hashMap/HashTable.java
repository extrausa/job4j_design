package ru.job4j.hashMap;

import java.util.*;

public class HashTable<K, V> implements Iterable<K> {
    private int arraySize;
    private int modCount = 0;
    private int DEFAULT_CAPACITY = 16;
    private double LOAD_FACTOR = 0.75;
    private DataItem<K, V>[] hashArray;
    private int count;

    public HashTable(int arraySize) {
        this.arraySize = arraySize;
        this.hashArray = new DataItem[arraySize];
    }

    public HashTable() {
        this.hashArray = new DataItem[DEFAULT_CAPACITY];
        arraySize = DEFAULT_CAPACITY;
    }

    private int inderFor(int h, int length) {
        return h & (length - 1);
    }

    public boolean insert(K key, V value) {
        arrayExtension();
        DataItem<K, V> temp = new DataItem<>(key, value);
        int has = inderFor(key.hashCode(), arraySize);
        if (hashArray[has] == null) {
            hashArray[has] = temp;
            count++;
            modCount++;
            return true;
        } else {
            if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
                hashArray[has].setValue(value);
                count++;
                modCount++;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return arraySize;
    }

    public V get(K key) {
        V temp;
        int has = inderFor(key.hashCode(), arraySize);
        if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
            temp = hashArray[has].getValue();
            return temp;
        }
        return null;
    }

    public boolean delete(K key) {
        boolean res = true;
        int has = inderFor(key.hashCode(), arraySize);
        if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
            hashArray[has] = null;
            modCount++;
            count--;
            return true;
        }
        return  false;
    }

    private void arrayExtension() {

        if ((float) count / hashArray.length > LOAD_FACTOR) {
            int sizeTemp = arraySize;
            int newSize = arraySize * 2;
            DataItem<K, V>[] temp = new DataItem[newSize];
            for (int i = 0; i < arraySize; i++) {
                if (hashArray[i] != null) {
                    temp[inderFor(hashArray[i].getKey().hashCode(), newSize)] = hashArray[i];
                }
            }
            hashArray = temp;
            arraySize = newSize;
        }
    }

    @Override
    public Iterator<K> iterator() {
        Iterator<K> it = new Iterator<K>() {
            private int expectedModCount = modCount;
            int counterArray = 0;
            int valuesCounter = 0;

            @Override
            public boolean hasNext() {
                while (valuesCounter < hashArray.length && hashArray[valuesCounter] == null) {

                    valuesCounter++;

                }

                return valuesCounter < hashArray.length;

            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
            }
                //valuesCounter++;
                return hashArray[valuesCounter++].getKey();
            }
        };
        return it;

    }

}
