package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    private int findId(String id) {
        int numbId = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                numbId = i;
            }
        }
        return numbId;
    }

    @Override
    public void add(T model) {
        int idIndex = findId(model.getId());
        if (idIndex == -1) {
            mem.add(model);
        } else {
            System.out.println("Такой ключ уже есть в списке");
        }
    }

    @Override
    public boolean replace(String id, T model) {
        int idIndex = findId(id);
        if (idIndex != -1) {
            mem.set(idIndex, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int idIndex = findId(id);
        if (idIndex != -1) {
            mem.remove(idIndex);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int idIndex = findId(id);
        if (idIndex != -1) {
            return mem.get(idIndex);
        }
        return null;
    }
}
