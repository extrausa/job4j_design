package ru.job4j.hashMap;

import java.util.*;

public class HashTable<K, V> implements Iterable<K> {
    private int arraySize;
    private int modCount = 0;
    private int DEFAULT_CAPACITY = 16;
    private DataItem<K, V>[] hashArray;
    private int empty;

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

    private int hashCode(int h, int length) {
        return h & (length - 1);
    }

    public boolean insert(K key, V value) {
        arrayExtension();
        DataItem<K, V> temp = new DataItem<>(key, value);
        int has = hashCode(key.hashCode(), arraySize);
        if (hashArray[has] == null) {
            hashArray[has] = temp;
            modCount++;
            return true;
        } else {
            if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
                hashArray[has].setValue(value);
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        V temp;
        int has = hashCode(key.hashCode(), arraySize);
        if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
            temp = hashArray[has].getValue();
            return temp;
        }
        return null;
    }

    public boolean delete(K key) {
        boolean res = true;
        int has = hashCode(key.hashCode(), arraySize);
        if (hashArray[has] != null && hashArray[has].getKey().equals(key)) {
            hashArray[has] = null;
            modCount++;
            return true;
        }
        return  false;
    }

    private void arrayExtension() {

        if (empty < arraySize / 2) {
            int sizeTemp = arraySize;
            int newSize = arraySize * 2;
            DataItem<K, V>[] temp = new DataItem[newSize];
            for (int i = 0; i < arraySize; i++) {
                temp[hashCode(hashArray[i].getKey().hashCode(), newSize)] = hashArray[i];
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
                if (valuesCounter == arraySize) {
                    return false;
                }
                if (hashArray[valuesCounter] == null) {
                    counterArray++;
                    while (counterArray < arraySize && hashArray[counterArray] == null) {
                        counterArray++;
                    }
                    valuesCounter = counterArray;
                    return  counterArray < arraySize && hashArray[counterArray] != null;
                }
                return true;

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
