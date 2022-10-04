package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args) {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        int[] inMass = new int[3];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i <= 2; i++) {
            inMass[i] = scan.nextInt();
        }

        int up = inMass[0];
        int down = inMass[1];
        int heigth = inMass[2];
        int days = 0;

        if (up >= heigth) {
            days++;
            System.out.print(days);
        }
         else {
             if (up > down){
                 for (int dayHeigth = up;dayHeigth <= heigth;dayHeigth += up - down,days++){

                 }
                 System.out.print(days);
             }
             else
                 System.out.print("Impossible");
        }

    }
}
