package ru.job4j.store;
//5.2.2. Реализовать Store<T extends Base> [#455157]
public class RoleStore implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {

    }

    @Override
    public boolean replace(String id, Role model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Role findById(String id) {
        return null;
    }
}
