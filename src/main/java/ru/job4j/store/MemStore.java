package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    private int position(String id) {
        int position = -1;
        position = mem.indexOf(id);
        return position;
    }

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int position = position(id);
        if (position == -1) {
            return false;
        } else {
            mem.set(position, model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        int position = position(id);
        if (position != -1) {
            mem.remove(position);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int position = position(id);
        if (position != -1) {
            return mem.get(position);
        }
        return null;
    }
}
