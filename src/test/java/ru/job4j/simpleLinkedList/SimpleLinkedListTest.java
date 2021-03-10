package ru.job4j.simpleLinkedList;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.simpleArray.SimpleArrayNew;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        Linked<String> array = new SimpleLinkedList<>();
        array.addFirst("first");
        array.addLast("second");
        array.addFirst("throw");
        array.addLast("4th");
        String rsl = array.getElement(0);
        assertThat(rsl, is("throw"));
    }

    @Test
    public void whenAddThenIt() {
        Linked<String> array = new SimpleLinkedList<>();
        array.addFirst("first");
        array.addLast("second");
        //array.addFirst("throw");
        array.addLast("4th");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Linked<String> array = new SimpleLinkedList<>();
        array.addFirst("first");
        Iterator<String> it = array.iterator();
        array.addFirst("second");
        it.next();
    }

}