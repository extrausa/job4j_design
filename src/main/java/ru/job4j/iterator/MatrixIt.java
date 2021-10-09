package ru.job4j.iterator;
/** Итератор для двухмерного массива int[][] [#455145] */
import java.util.NoSuchElementException;
import java.util.Iterator;

public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        while (data.length > row && data[row].length == column) {

            row++;
            column = 0;

        }

        return row < data.length && data[row].length > column;

    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Override
    public Integer next() {
      if (!hasNext()) {
          throw new NoSuchElementException();
      }

      return data[row][column++];
    }
}
