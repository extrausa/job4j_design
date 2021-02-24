package ru.job4j.simpleArray;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleArrayTest {
    @Test
    public void addTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.add(6);
        first.add(7);
        first.add(8);
        Iterator<Integer> iterator = first.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(5));
    }

    @Test
    public void removeTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.add(6);
        first.remove(1);
        Iterator<Integer> iterator = first.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(6));
    }

    @Test
    public void setTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.set(0, 9);
        Iterator<Integer> iterator = first.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(9));
    }

    @Test
    public void getTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.add(6);
        first.add(7);
        first.add(8);
        Iterator<Integer> iterator = first.iterator();
        assertTrue(iterator.hasNext());
        assertThat(first.get(2), is(7));


    }

}