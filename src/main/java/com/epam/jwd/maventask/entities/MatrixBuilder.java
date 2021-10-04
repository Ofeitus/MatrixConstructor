package com.epam.jwd.maventask.entities;

import com.epam.jwd.maventask.exeption.MatrixSizeException;
import com.epam.jwd.maventask.logic.filler.MatrixFiller;
import com.epam.jwd.maventask.logic.filler.impl.SolidMatrixFiller;
import com.epam.jwd.maventask.logic.validator.MatrixValidator;

public class MatrixBuilder {
    private int rows;
    private int columns;
    private MatrixFiller filler;
    private final MatrixValidator matrixValidator;

    public MatrixBuilder() {
        this.rows = 0;
        this.columns = 0;
        this.filler = new SolidMatrixFiller();
        this.matrixValidator = new MatrixValidator();
    }

    public void setRows(int rows) throws MatrixSizeException {
        String validationResult = matrixValidator.validateRowsCount(rows);
        if (validationResult.equals("OK")) {
            this.rows = rows;
        } else {
            throw new MatrixSizeException(validationResult);
        }
    }

    public void setColumns(int columns) throws MatrixSizeException {
        String validationResult = matrixValidator.validateColumnsCount(columns);
        if (validationResult.equals("OK")) {
            this.columns = columns;
        } else {
            throw new MatrixSizeException(validationResult);
        }
    }

    public void setFiller(MatrixFiller filler) {
        this.filler = filler;
    }

    public Matrix build() {
        return new Matrix(filler.fillMatrix(new int[rows][columns]));
    }
}
