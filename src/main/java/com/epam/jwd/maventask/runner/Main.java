package com.epam.jwd.maventask.runner;

import com.epam.jwd.maventask.entities.Matrix;
import com.epam.jwd.maventask.entities.MatrixBuilder;
import com.epam.jwd.maventask.exeption.MatrixSizeException;
import com.epam.jwd.maventask.logic.filler.Pattern;
import com.epam.jwd.maventask.logic.filler.impl.PatternMatrixFiller;
import com.epam.jwd.maventask.logic.filler.impl.SolidMatrixFiller;
import com.epam.jwd.maventask.view.impl.ConsoleMatrixPrinter;

public class Main {
    public static void main(String[] args) {
        MatrixBuilder matrixBuilder = new MatrixBuilder();

        try {
            matrixBuilder.setColumns(4);
            matrixBuilder.setRows(4);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new SolidMatrixFiller(1));
        Matrix solidMatrix = matrixBuilder.build();

        try {
            matrixBuilder.setColumns(8);
            matrixBuilder.setRows(5);
        } catch (MatrixSizeException e) {
            System.out.println(e.getMessage());
        }
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.BACK_AND_FORTH));
        Matrix patternMatrix1 = matrixBuilder.build();
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.CHESS));
        Matrix patternMatrix2 = matrixBuilder.build();
        matrixBuilder.setFiller(new PatternMatrixFiller(Pattern.SPIRAL));
        Matrix patternMatrix3 = matrixBuilder.build();

        ConsoleMatrixPrinter matrixPrinter = new ConsoleMatrixPrinter();
        System.out.println("Matrix filled with ones");
        matrixPrinter.printMatrix(solidMatrix);
        System.out.println("\nMatrix filled with back and forth pattern");
        matrixPrinter.printMatrix(patternMatrix1);
        System.out.println("\nMatrix filled with chess pattern");
        matrixPrinter.printMatrix(patternMatrix2);
        System.out.println("\nMatrix filled with spiral pattern");
        matrixPrinter.printMatrix(patternMatrix3);
    }
}
