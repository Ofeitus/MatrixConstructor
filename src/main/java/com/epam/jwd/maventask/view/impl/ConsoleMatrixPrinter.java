package com.epam.jwd.maventask.view.impl;

import com.epam.jwd.maventask.entities.Matrix;
import com.epam.jwd.maventask.view.MatrixPrinter;

public class ConsoleMatrixPrinter implements MatrixPrinter {
    public void printMatrix(Matrix matrix) {
        int[][] data = matrix.getData();
        if (data.length < 1) {
            return;
        }
        if (data[0].length < 1) {
            return;
        }
        int max = data[0][0];
        for (int[] row : data) {
            for (int item : row) {
                if (item > max) {
                    max = item;
                }
            }
        }

        String format = "%" + String.valueOf(max).length() + "d ";

        for (int[] row : data) {
            for (int item : row) {
                System.out.printf(format, item);
            }
            System.out.println();
        }
    }
}
