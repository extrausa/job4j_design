package ru.job4j.simpleArray;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    @Test
    public void addTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        int[] tester = new int[] {5};
        assertThat(first.iterator().next(), is(tester[0]));

    }

    @Test
    public void removeTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.add(6);
        first.remove(1);
        int[] tester = new int[] {6};
        assertThat(first.iterator().next(), is(tester[0]));

    }

    @Test
    public void setTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        first.set(0, 9);
        int[] tester = new int[] {9};
        assertThat(first.iterator().next(), is(tester[0]));

    }

    @Test
    public void getTest() {
        SimpleArray<Integer> first = new SimpleArray<>(5);
        first.add(5);
        int[] tester = new int[] {5};
        assertThat(first.get(0), is(tester[0]));

    }

}