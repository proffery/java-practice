package com.epam.training.student_dmitry_shamko;

public class MaxMethod {
    public static int max(int[] values) {
        //throw new UnsupportedOperationException();
        int maxVal = values[0];
        for (int intVal : values) {
            if (maxVal < intVal) {
                maxVal = intVal;
            }
        }
        return maxVal;
    }
}
