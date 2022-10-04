package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length != 0) {
            int[] arrayTemp = new int[array.length];
            arrayTemp[0] = array[array.length - 1];
            System.arraycopy(array, 0, arrayTemp, 1, array.length - 1);
            System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        }
    }

    static void cycleSwap ( int[] array, int shift) {
        if (array.length != 0) {
            int[] arrayShift = new int[array.length];
            for (int i = shift; i > 0; i--) {
                arrayShift[shift - i] = array[array.length - i];
            }
            System.arraycopy(array, 0, arrayShift, shift, array.length - shift);
            System.arraycopy(arrayShift, 0, array, 0, arrayShift.length);
        }
    }
}
