package com.epam.jwd.maventask.logic.validator;

public class MatrixValidator {
    private static final String OK = "OK";
    private static final String ERROR_INVALID_ROWS_COUNT = "Invalid rows count";
    private static final String ERROR_INVALID_COLUMNS_COUNT = "Invalid columns count";

    public String validateRowsCount(int rows) {
        if (rows < 0) {
            return ERROR_INVALID_ROWS_COUNT;
        } else {
            return OK;
        }
    }

    public String validateColumnsCount(int columns) {
        if (columns < 0) {
            return ERROR_INVALID_COLUMNS_COUNT;
        } else {
            return OK;
        }
    }
}
