package ru.job4j.store;

import java.util.Objects;

/**5.2.2. Реализовать Store<T extends Base> [#455157]*/
public class RoleStore implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
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
    public Role findById(String id) {
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
        RoleStore roleStore = (RoleStore) o;
        return Objects.equals(store, roleStore.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store);
    }
}
