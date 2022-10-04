package com.epam.training.student_dmitry_shamko;

import java.util.Arrays;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int numCount = 1;
        int lapCount = 0;

        if (rows == 1 && columns == 1) {
            int[][] spiral = new int[][]{{1}};
            return spiral;
        }

        else if (rows == 1) {
            int[][] spiral = new int[1][columns];

            for (int i = 0; i < spiral[0].length; i++) {
                spiral[0][i] = numCount++;
            }

            return spiral;
        }

        else if (columns == 1) {
            int[][] spiral = new int[rows][1];

            for (int i = 0; i < spiral.length; i++) {
                spiral[i][0] = numCount++;
            }
            return spiral;
        }

        else {
            int[][] spiral = new int[rows][columns];

            while (numCount < rows * columns) {
                if (numCount < rows * columns) {
                    if (lapCount > 1) {
                        for (int i = 1; i < spiral[lapCount].length - lapCount; i++) {
                            spiral[lapCount][i] = numCount++;
                        }
                    }

                    else {
                        for (int i = 0; i < spiral[lapCount].length - lapCount; i++) {
                            spiral[lapCount][i] = numCount++;
                        }
                    }
                    numCount--;
                }

                if (numCount < rows * columns) {
                    for (int i = lapCount; i < spiral.length - lapCount; i++) {
                        spiral[i][spiral[lapCount].length - 1 - lapCount] = numCount++;
                    }
                    numCount--;
                }

                if (numCount < rows * columns) {
                    for (int i = spiral[spiral.length - 1].length - 1 - lapCount; i >= lapCount; i--) {
                        spiral[spiral.length - 1 - lapCount][i] = numCount++;
                    }
                    numCount--;
                }

                if (numCount < rows * columns) {
                    for (int i = spiral.length - 1 - lapCount; i > lapCount; i--) {
                        spiral[i][lapCount] = numCount++;
                    }
                    numCount--;
                }
                lapCount++;
            }
            return spiral;
        }

    }

}