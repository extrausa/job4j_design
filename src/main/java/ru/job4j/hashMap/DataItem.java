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

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        DataItem<?, ?> dataItem = (DataItem<?, ?>) object;
        return java.util.Objects.equals(key, dataItem.key) && java.util.Objects.equals(value, dataItem.value);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), key, value);
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
