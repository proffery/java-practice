package com.epam.training.student_dmitry_shamko;

import java.util.Scanner;
import java.util.Arrays;
public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner scanSeq = new Scanner(System.in);
        String sequence = scanSeq.nextLine();
        String[] inMass = sequence.split(" ");

        int[] intSeq = new int[inMass.length];
        int max;

        for (int i = 0; i < intSeq.length; i++) {
            intSeq[i] = Integer.parseInt(inMass[i]);
        }

        Arrays.sort(intSeq);

        if (intSeq[intSeq.length - 1] != 0)
        {
            max = intSeq[intSeq.length - 1];
        }
        else{
            max = intSeq[intSeq.length - 2];
        }
        return max;
    }




    public static void main(String[] args) {

        // Get a result of your code

        System.out.println(max());
    }
}
