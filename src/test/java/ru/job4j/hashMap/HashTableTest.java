package ru.job4j.hashMap;

import junit.framework.TestCase;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import ru.job4j.iterator.BackwardArrayIt;
import ru.job4j.simpleArray.SimpleArrayNew;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HashTableTest {

    @Test
    public void whenInsert() {
        HashTable<Integer, Integer> test = new HashTable<>();
        test.insert(2, 2);
        test.insert(3, 2);
        test.insert(4, 2);
        test.insert(5, 2);
        test.insert(6, 2);
        assertThat(test.get(2), is (2));
    }

    @Test
    public void whenFalse() {
        HashTable<Integer, Integer> test = new HashTable<>();
        test.insert(2, 2);
        assertThat(test.insert(2, 4), is (true));
    }
    @Test
    public void whenGetNotNull() {
        HashTable<Integer, Integer> test = new HashTable<>();
        test.insert(2, 4);
        assertThat(test.get(2), is (4));
    }

    @Test
    public void whenDeleted() {
        HashTable<Integer, String> test = new HashTable<>();
        test.insert(2, "2");
        test.insert(3, "2");
        test.insert(4, "2");
        test.insert(5, "2");
        test.insert(6, "2");
        assertThat(test.delete(2), is (true));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        HashTable<Integer, String> test = new HashTable<>();
        test.insert(1, "first");
        Iterator<Integer> it = test.iterator();
        test.insert(2, "second");
        it.next();
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        HashTable<Integer, Integer> test = new HashTable<>();
        test.insert(2, 2);
        test.insert(3, 2);
        test.insert(4, 2);
        assertThat(test.iterator().hasNext(), is (true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        HashTable<Integer, Integer> test = new HashTable<>();
        test.iterator().next();
    }

}