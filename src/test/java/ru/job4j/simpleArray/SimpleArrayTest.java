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
        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);
        first.add(5);

        Integer[] test = new Integer[]{1, 2, 3, 4, 5};
        assertThat(first.iterator().next(), is(test));

    }


}