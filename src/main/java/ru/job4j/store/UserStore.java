package ru.job4j.store;

import java.util.Objects;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        if (store.replace(id, model)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (store.delete(id)) {
            return true;
        }
        return false;
    }

    @Override
    public User findById(String id) {
        if (store.findById(id) != null) {
            return store.findById(id);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserStore userStore = (UserStore) o;
        return Objects.equals(store, userStore.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store);
    }
}
