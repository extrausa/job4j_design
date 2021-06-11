package ru.job4j.collectionstatistics;
//2. Статистику по коллекции. [#45889]

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        boolean check = Collections.disjoint(previous, current);
        Info change = new Info();
        change.added = 0;
        change.changed = 0;
        change.deleted = 0;
        int sizePrev = previous.size();
        int sizeCurr = current.size();
        int countStep = 0;
        int numbercount = 0;
        if (check) {
            return change;
        } else {
//            for (int i = 0; i < previous.size(); i++) {
//                numbercount = 0;
//                for (int j = 0; j < current.size(); j++) {
//                    if (previous.get(i).name.equals(current.get(j).name) &&
//                            previous.get(i).id == current.get(j).id){
//                        numbercount++;
//                    } else if (previous.get(i).id == current.get(j).id &&
//                            !previous.get(i).name.equals(current.get(j).name)) {
//                        numbercount = 2;
//                        change.changed = 1;
//                    }
//
//                }
//                if (numbercount == 0 && sizePrev > sizeCurr) {
//                    change.deleted = 1;
//                } else if (numbercount == 2 && sizePrev <= sizeCurr ||
//                        numbercount == 2 && sizePrev >= sizeCurr ||
//                        numbercount == 0 && sizePrev <= sizeCurr){
//                    change.added = 1;
//                }
//        }
//    }
//            List<User> toInsert = new ArrayList<User>();
//            List<User> toUpdate = new ArrayList<User>();
//            List<User> toDelete = new ArrayList<User>();
            HashMap<Integer, User> localUserMap = new HashMap<>();
            for (User user : current) {
                localUserMap.put(user.getId(), user);
            }

            for (User user : previous) {
                numbercount = 0;
                countStep++;

                if(localUserMap.size() == countStep - 1) {
                    break;
                }
                if (localUserMap.get(user.getId()).getName().equals(user.getName())) {
                    //toUpdate.add(user);
                    numbercount++;
                    //change.changed++;
                } else {
                    //toInsert.add(user);
                    numbercount++;
                    change.changed++;
                    change.added++;
                }
                current.remove(user);
            }
            //toDelete.addAll(localUserMap.values());
            change.deleted = current.size();
//            change.added = toInsert.size();
//            change.changed = toUpdate.size();
//            change.deleted = toDelete.size();
        }
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
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
