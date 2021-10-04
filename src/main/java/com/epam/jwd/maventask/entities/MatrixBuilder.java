package com.epam.jwd.maventask.entities;

import com.epam.jwd.maventask.exeption.MatrixSizeException;
import com.epam.jwd.maventask.logic.filler.MatrixFiller;
import com.epam.jwd.maventask.logic.filler.impl.SolidMatrixFiller;

public class MatrixBuilder {
    private int rows;
    private int columns;
    private MatrixFiller filler;

    public MatrixBuilder() {
        this.rows = 0;
        this.columns = 0;
        this.filler = new SolidMatrixFiller();
    }

    public void setRows(int rows) throws MatrixSizeException {
        if (rows >= 0) {
            this.rows = rows;
        } else {
            throw new MatrixSizeException("Invalid rows count");
        }
    }

    public void setColumns(int columns) throws MatrixSizeException {
        if (columns >= 0) {
            this.columns = columns;
        } else {
            throw new MatrixSizeException("Invalid columns count");
        }
    }

    public void setFiller(MatrixFiller filler) {
        this.filler = filler;
    }

    public Matrix build() {
        return new Matrix(filler.fillMatrix(new int[rows][columns]));
    }
}
