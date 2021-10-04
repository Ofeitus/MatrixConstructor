package com.epam.jwd.maventask.logic.filler.impl;

import com.epam.jwd.maventask.logic.filler.MatrixFiller;

public class SolidMatrixFiller implements MatrixFiller {
    private final int value;

    public SolidMatrixFiller() {
        this.value = 0;
    }

    public SolidMatrixFiller(int value) {
        this.value = value;
    }

    public int[][] fillMatrix(int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = value;
            }
        }
        return data;
    }
}
