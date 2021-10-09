package ru.job4j.collectionstatistics;
/** Статистику по коллекции. [#45889] */

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info change = new Info();
        change.added = 0;
        change.changed = 0;
        change.deleted = 0;
        int sizeCurr = 0;
        HashMap<Integer, User> localUserMap = new HashMap<>();
          for (User user : current) {
              localUserMap.put(user.getId(), user);
          }
         for (User user : previous) {
             if (localUserMap.get(user.getId()) == null) {
                 break;
             }
                if (localUserMap.get(user.getId()).getName().equals(user.getName())) {
                    current.remove(user);
                } else {
                    change.changed++;
                    change.added++;
                    sizeCurr++;
                }
            }
            change.deleted = current.size() - sizeCurr;
       return change;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
