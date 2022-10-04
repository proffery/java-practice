package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int [][] resultMatrix = new int[matrix1.length][matrix2[0].length];

        for (int j = 0; j < matrix1.length; j++) {
            for (int i = 0; i < matrix2[0].length; i++) {
                for (int n = 0; n < matrix2.length; n++) {
                    resultMatrix[j][i] += matrix1[j][n] * matrix2[n][i];
                }
            }
        }
        return resultMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {1,2,3,5},
                {4,5,6,4},
                {1,2,3,5} };

        int[][] b = {
                {7,8,6},
                {9,10,8},
                {11,12,3},
                {13,14,1} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
