package ru.job4j.collectionstatistics;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void whenChangeAddDelet() {
        Analize start = new Analize();
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Denis"),
                new Analize.User(10, "Ivan"),
                new Analize.User(13, "Denis"),
                new Analize.User(4, "Denis"),
                new Analize.User(5, "Denis")
        ));

        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Denis"),
                new Analize.User(10, "Sergey"),
                new Analize.User(13, "Denis"),
                new Analize.User(4, "Denis")
        ));

        Analize.Info create = start.diff(previous, current);
        assertThat(create.added, is (1));
        assertThat(create.changed, is (1));
        assertThat(create.deleted, is (1));
    }

    @Test
    public void whenEquals() {
        Analize start = new Analize();
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Denis"),
                new Analize.User(10, "Ivan"),
                new Analize.User(13, "Denis"),
                new Analize.User(4, "Denis"),
                new Analize.User(5, "Denis")
        ));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "Denis"),
                new Analize.User(10, "Ivan"),
                new Analize.User(13, "Denis"),
                new Analize.User(4, "Denis"),
                new Analize.User(5, "Denis")
        ));

        Analize.Info create = start.diff(previous, current);
        assertThat(create.added = 0, is (0));
        assertThat(create.changed = 0, is (0));
        assertThat(create.deleted = 0, is (0));
    }


}