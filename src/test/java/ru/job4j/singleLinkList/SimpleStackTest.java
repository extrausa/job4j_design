package ru.job4j.singleLinkList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SimpleStackTest {
    @Test
    public void whenPushThenPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void whenPushPollThenPushPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.display();
        assertThat(stack.pop(), is(2));
    }

    @Test
    public void whenPushPushThenPollPoll() {
        SimpleStack<Integer> stack = new SimpleStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();
        assertThat(stack.pop(), is(3));
    }

}