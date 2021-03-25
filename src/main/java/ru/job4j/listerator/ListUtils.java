package ru.job4j.listerator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                break;
            }
            i.next();
        }

    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(list.get(i.nextIndex()))) {
                i.next();
                i.remove();
            }
            if (!i.hasNext()) {
                break;
            }
            i.next();
        }

    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(list.get(i.nextIndex()))) {
                i.next();
                i.set(value);
            }
            if (!i.hasNext()) {
                break;
            }
            i.next();
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        ListIterator<T> b = elements.listIterator();
        while (b.hasNext()) {
            if (!i.hasNext()) {
                i = list.listIterator(list.size());
                while (i.hasPrevious()) {
                    i.previous();
                }
            }
            while (i.hasNext()) {
                if (list.get(i.nextIndex()).equals(elements.get(b.nextIndex()))) {
                    i.next();
                    i.remove();
                }
                if (!i.hasNext()) {
                    break;
                }
                i.next();

            }
            if (!b.hasNext()) {
                break;
            }
            b.next();
        }
    }
}
