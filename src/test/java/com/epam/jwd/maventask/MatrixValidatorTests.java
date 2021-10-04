package com.epam.jwd.maventask;

import com.epam.jwd.maventask.logic.validator.MatrixValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixValidatorTests {
    @Test
    void testRowsCountValidation() {
        // arrange
        MatrixValidator matrixValidator = new MatrixValidator();
        // act
        String validationResult = matrixValidator.validateRowsCount(0);
        // assert
        Assertions.assertEquals(validationResult, "OK");
    }

    @Test
    void testColumnsCountValidation() {
        // arrange
        MatrixValidator matrixValidator = new MatrixValidator();
        // act
        String validationResult = matrixValidator.validateColumnsCount(3);
        // assert
        Assertions.assertEquals(validationResult, "OK");
    }

    @Test
    void testInvalidRowsCountValidation() {
        // arrange
        MatrixValidator matrixValidator = new MatrixValidator();
        // act
        String validationResult = matrixValidator.validateRowsCount(-1);
        // assert
        Assertions.assertEquals(validationResult, "Invalid rows count");
    }

    @Test
    void testInvalidColumnsCountValidation() {
        // arrange
        MatrixValidator matrixValidator = new MatrixValidator();
        // act
        String validationResult = matrixValidator.validateColumnsCount(-3);
        // assert
        Assertions.assertEquals(validationResult, "Invalid columns count");
    }
}
