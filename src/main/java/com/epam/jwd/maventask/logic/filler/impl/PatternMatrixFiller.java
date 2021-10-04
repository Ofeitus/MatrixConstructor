package com.epam.jwd.maventask.logic.filler.impl;

import com.epam.jwd.maventask.logic.filler.MatrixFiller;
import com.epam.jwd.maventask.logic.filler.Pattern;

public class PatternMatrixFiller implements MatrixFiller {
    private final Pattern pattern;

    public PatternMatrixFiller() {
        this.pattern = Pattern.BACK_AND_FORTH;
    }

    public PatternMatrixFiller(Pattern pattern) {
        this.pattern = pattern;
    }

    public int[][] fillMatrix(int[][] data) {
        switch (pattern) {
            case BACK_AND_FORTH:
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j] = (i % 2 == 0) ? j + 1 : data[i].length - j;
                    }
                }
                break;
            case CHESS:
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j] = (i + j) % 2 == 0 ? 0 : 1;
                    }
                }
                break;
            case SPIRAL:
                int iBeg = 0, iFin = 0, jBeg = 0, jFin = 0;

                int k = 1;
                int i = 0;
                int j = 0;

                if (data.length > 0) {
                    while (k <= data.length * data[0].length) {
                        data[i][j] = k;
                        if (i == iBeg && j < data[0].length - jFin - 1) {
                            ++j;
                        } else if (j == data[0].length - jFin - 1 && i < data.length - iFin - 1) {
                            ++i;
                        } else if (i == data.length - iFin - 1 && j > jBeg) {
                            --j;
                        } else {
                            --i;
                        }

                        if ((i == iBeg + 1) && (j == jBeg) && (jBeg != data[0].length - jFin - 1)) {
                            ++iBeg;
                            ++iFin;
                            ++jBeg;
                            ++jFin;
                        }
                        ++k;
                    }
                }
                break;
        }


        return data;
    }
}
