package com.epam.jwd.maventask;

import com.epam.jwd.maventask.entities.Matrix;
import com.epam.jwd.maventask.entities.MatrixBuilder;
import com.epam.jwd.maventask.exeption.MatrixSizeException;
import com.epam.jwd.maventask.logic.filler.Pattern;
import com.epam.jwd.maventask.logic.filler.impl.PatternMatrixFiller;
import com.epam.jwd.maventask.logic.filler.impl.SolidMatrixFiller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class MatrixTest {
    private final MatrixBuilder matrixBuilder = new MatrixBuilder();

    @Test
    void testSolidMatrix() {
        // arrange
        try {
            matrixBuilder.setColumns(1);
            matrixBuilder.setRows(1);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new SolidMatrixFiller(13));
        int[][] testMatrix = new int[][]
                {{13}};

        // act
        Matrix patternMatrix = matrixBuilder.build();

        // assert
        Assertions.assertTrue(Arrays.deepEquals(patternMatrix.getData(), testMatrix));
    }

    @Test
    void testBackAndForthPattern() {
        // arrange
        try {
            matrixBuilder.setColumns(3);
            matrixBuilder.setRows(5);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.BACK_AND_FORTH));
        int[][] testMatrix = new int[][]
                {{1, 2, 3},
                {3, 2, 1},
                {1, 2, 3},
                {3, 2, 1},
                {1, 2, 3}};

        // act
        Matrix patternMatrix = matrixBuilder.build();

        // assert
        Assertions.assertTrue(Arrays.deepEquals(patternMatrix.getData(), testMatrix));
    }

    @Test
    void testChessPattern() {
        // arrange
        try {
            matrixBuilder.setColumns(4);
            matrixBuilder.setRows(4);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.CHESS));
        int[][] testMatrix = new int[][]
                {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};

        // act
        Matrix patternMatrix = matrixBuilder.build();

        // assert
        Assertions.assertTrue(Arrays.deepEquals(patternMatrix.getData(), testMatrix));
    }

    @Test
    void testSpiralPattern() {
        // arrange
        try {
            matrixBuilder.setColumns(4);
            matrixBuilder.setRows(3);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.SPIRAL));
        int[][] testMatrix = new int[][]
                {{1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}};

        // act
        Matrix patternMatrix = matrixBuilder.build();

        // assert
        Assertions.assertTrue(Arrays.deepEquals(patternMatrix.getData(), testMatrix));
    }
}
