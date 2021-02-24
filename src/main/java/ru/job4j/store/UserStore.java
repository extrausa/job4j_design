package ru.job4j.store;

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
}
