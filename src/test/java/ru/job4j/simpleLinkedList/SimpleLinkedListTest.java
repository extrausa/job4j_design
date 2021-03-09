package ru.job4j.simpleLinkedList;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.simpleArray.SimpleArrayNew;

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
        String rsl = array.getElement(3);
        assertThat(rsl, is("4th"));
    }

    @Test
    public void whenAddThenIt() {
        Linked<String> array = new SimpleLinkedList<>();
        array.addFirst("first");
        array.addLast("second");
        array.addFirst("throw");
        array.addLast("4th");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

}