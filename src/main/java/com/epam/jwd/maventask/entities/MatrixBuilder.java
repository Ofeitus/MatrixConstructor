package com.epam.jwd.maventask.entities;

import com.epam.jwd.maventask.exeption.MatrixSizeException;
import com.epam.jwd.maventask.logic.filler.MatrixFiller;
import com.epam.jwd.maventask.logic.filler.impl.SolidMatrixFiller;
import com.epam.jwd.maventask.validator.MatrixValidator;

public class MatrixBuilder {
    private int rows;
    private int columns;
    private MatrixFiller filler;
    private MatrixValidator matrixValidator;

    public MatrixBuilder() {
        this.rows = 0;
        this.columns = 0;
        this.filler = new SolidMatrixFiller();
        this.matrixValidator = new MatrixValidator();
    }

    public void setRows(int rows) throws MatrixSizeException {
        String validationMessage = matrixValidator.validateRowsCount(rows);
        if (validationMessage.equals("OK")) {
            this.rows = rows;
        } else {
            throw new MatrixSizeException(validationMessage);
        }
    }

    public void setColumns(int columns) throws MatrixSizeException {
        String validationMessage = matrixValidator.validateColumnsCount(columns);
        if (validationMessage.equals("OK")) {
            this.columns = columns;
        } else {
            throw new MatrixSizeException(validationMessage);
        }
    }

    public void setFiller(MatrixFiller filler) {
        this.filler = filler;
    }

    public Matrix build() {
        return new Matrix(filler.fillMatrix(new int[rows][columns]));
    }
}
