package com.epam.jwd.maventask.entities;

public class Matrix {
    protected final int[][] data;

    private int[][] copy2DArray(int[][] array) {
        int[][] copy = new int[array.length][];
        for(int i = 0; i < array.length; i++)
            copy[i] = array[i].clone();
        return copy;
    }

    public Matrix(int[][] data) {
        this.data = copy2DArray(data);
    }

    public int[][] getData() {
        return copy2DArray(data);
    }
}
