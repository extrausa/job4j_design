package ru.job4j.iterator;
//5.1.1. Итератор для двухмерного массива int[][] [#455145]
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
        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data[i].length; j++) {

                if (row + 1 == data.length) {
                        return column < data[row].length;
                }
                if (column >= data[row].length && (row >= data.length || row == data.length - 1)) {
                        return false;
                }

            }
            if (i == data.length - 1 && data[i].length == 0) {
                return false;
            }
        }
        return  true;
    }

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length && row < data.length) {
            row = data.length - 1;
            column = 0;
        }
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
        return data[row][column++];
    }
}
