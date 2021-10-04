package com.epam.jwd.maventask.exeption;

public class MatrixSizeException extends Exception {
    public MatrixSizeException() {
        super();
    }

    public MatrixSizeException(String message) {
        super(message);
    }

    public MatrixSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixSizeException(Throwable cause) {
        super(cause);
    }
}
