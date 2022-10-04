package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        if (matrix[0].length == matrix.length) {
            int[][] matrixNEW = new int[matrix.length][matrix.length];
            for (int j = 0; j < matrixNEW.length; j++) {
                for (int i = 0; i < matrixNEW[j].length; i++) {
                    matrixNEW[j][i] = matrix[i][j];
                }
            }
            return matrixNEW;
        }
        else {
            int[][] matrixNEW = new int[matrix[0].length][matrix.length];
            for (int j = 0; j < matrixNEW.length; j++) {
                for (int i = 0; i < matrixNEW[j].length; i++) {
                    matrixNEW[j][i] = matrix[i][j];
                }
            }
            return matrixNEW;
        }
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {3, 4},
                {5, 6}};

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
