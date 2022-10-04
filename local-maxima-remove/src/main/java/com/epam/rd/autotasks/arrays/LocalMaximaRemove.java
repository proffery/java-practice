package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        int[] resultArray = new int[array.length + 1];
        int countMax = 0;
        resultArray[0] = array[0];
        
        for (int i = 1; i <= array.length - 1; i++) {
            if (i == array.length - 1) {
                resultArray[array.length - countMax - 1] = array[array.length - 1];
            }
            else if (array[i] > array[i + 1]  && array[i] > array[i - 1]) {
                countMax++;
                resultArray[i] = array[i + 1];
            }
            else {
                resultArray[i - countMax] = array[i];
            }
        }

        int[] returnArray;

        if  (array[0] > array[1] && array[array.length - 1] > array[array.length - 2]) {
            returnArray = Arrays.copyOfRange(resultArray, 1,array.length - countMax - 1);
        }
        else if (array[0] > array[1] ) {
            returnArray = Arrays.copyOfRange(resultArray, 1,array.length - countMax);
        }
        else if (array[array.length - 1] > array[array.length - 2]) {
            returnArray = Arrays.copyOfRange(resultArray, 0,array.length - countMax - 1);
        }
        else {
            returnArray = Arrays.copyOf(resultArray, array.length - countMax);
        }
        return returnArray;
        //throw new UnsupportedOperationException();
    }
}
