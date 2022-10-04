package com.epam.training.student_dmitry_shamko;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){
        boolean[] boolMass = new boolean[array.length];
        boolMass[0] = false;
        boolMass[1] = false;
            for (int iter = 0; iter < array.length - 2; iter++) {
                boolMass[iter + 2] = array[iter + 2] == array[iter + 1] + array[iter];
        }
            return boolMass;
        //throw new UnsupportedOperationException();
    }
}
