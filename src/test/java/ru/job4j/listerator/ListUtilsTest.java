package ru.job4j.listerator;
//7. ListIterator [#455134]
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input,2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 0, 1, 2, 3, 1, 4, 1));
        Predicate<Integer> predicate = t -> t == 1;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(0, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenreplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 1));
        Predicate<Integer> predicate = t -> t == 1;
        ListUtils.replaceIf(input, predicate, 4);
        assertThat(Arrays.asList(0, 4, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenremoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 3));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(0, 1), Is.is(input));
    }

}