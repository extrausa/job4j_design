package ru.job4j.hashMap;

import java.util.Objects;

public class DataItem<K, V> {
    private final K key;
    private V value;

    public DataItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataItem<?, ?> dataItem = (DataItem<?, ?>) o;
        return Objects.equals(key, dataItem.key) && Objects.equals(value, dataItem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
