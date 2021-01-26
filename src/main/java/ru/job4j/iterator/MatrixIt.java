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

       //return  column < data[row].length && row < data.length;
        if (row + 1 == data.length) {
            return column < data[row].length;
        }
        if (row == data.length - 1 && column == data[row].length - 1) {
            return false;
        }

        return  row < data.length;

    }

    @Override
    public Integer next() {
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        if (!hasNext()) {

            throw new NoSuchElementException();
        }
        //column++;

        return data[row][column++];
    }
}
