package com.epam.training.student_dmitry_shamko;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){

        if(array != null ) {
            int summ = 0;
            for (int val:array) {
                summ += val;
            }
            summ = 0;
            for (int val:array) {
                if (val % 2 == 0) {
                    summ += val;
                }
            }
            return summ;
        }

        return 0;//throw new UnsupportedOperationException();
    }
}
