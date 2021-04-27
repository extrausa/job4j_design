package ru.job4j.hashMap;

import java.util.*;

public class HashTable<K, V> implements Iterator<V> {
    private int arraySize;
    private int modCount = 0;
    private int expectedModCount = 0;
    private int DEFAULT_CAPACITY = 16;
    private DataItem<K, V>[] hashArray;
    int counterArray, valuesCounter;
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
            if (hashCode(hashArray[has].getKey().hashCode(), arraySize) == has) {
                hashArray[has].setValue(value);
                return false;
            }

        }
        return true;
    }

    public V get(K key) {
        return hashArray[hashCode(key.hashCode(), arraySize)].getValue();
    }

    public boolean delete(K key) {
        boolean res = true;
        int has = hashCode(key.hashCode(), arraySize);
        if (hashCode(hashArray[has].getKey().hashCode(), arraySize) == has) {
            hashArray[has] = null;
            expectedModCount = modCount;
            expectedModCount--;
            return true;
        }
        return  false;
    }

    private void arrayExtension() {
        if (empty < arraySize / 2) {
            int newSize = arraySize * 2;
            DataItem<K, V>[] temp = new DataItem[newSize];
            for (int i = 0; i < arraySize; i++) {
                temp[i] = hashArray[i];
            }
            hashArray = temp;
        }
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
        return true;
    }

    private boolean moveToNextCell() {
        counterArray++;
        while (counterArray < arraySize && hashArray[counterArray] == null) {
            counterArray++;
        }
        return  counterArray < arraySize && hashArray[counterArray] != null;
    }

    final void checkForComodification() {
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }

    @Override
    public V next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        checkForComodification();
        valuesCounter++;
        return hashArray[valuesCounter].getValue();
    }
}
