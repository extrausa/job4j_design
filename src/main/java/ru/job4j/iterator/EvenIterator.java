package ru.job4j.iterator;
/**5.1.2. Создать итератор четные числа [#455142]*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] data;
    int counter = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (counter < data.length) {
            if (data[counter] % 2 == 0) {
                return true;
            }
            counter++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[counter++];
    }

}
