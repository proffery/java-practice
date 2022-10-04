package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanSeq = new Scanner(System.in);
        String sequence = scanSeq.nextLine();
        String[] inMass = sequence.split(" ");

        int[] intSeq = new int[inMass.length];
        int summ = 0;
        for (int i = 0 ; i < intSeq.length; i++) {
            intSeq[i] = Integer.parseInt(inMass[i]);
            summ += intSeq[i];
        }
        int avrg = summ / (intSeq.length - 1);
        System.out.println(avrg);
    }

}
