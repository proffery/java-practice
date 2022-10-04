package com.epam.training.student_dmitry_shamko;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanNum = new Scanner(System.in);
        int numberCount = scanNum.nextInt();

        if (numberCount > 0) {
            String[] finalName = new String[numberCount];
            for (int i = 0; i < numberCount; i++) {
                Scanner scanName = new Scanner(System.in);
                String numberName = scanName.nextLine();
                finalName[i] = numberName;
            }

        int n = 0;
            while (n < numberCount) {
                System.out.println("Hello, " + finalName[n]);
                n++;
            }
        }
        else {
             if (numberCount == 0)
                 System.out.println("Oh, it looks like there is no one here");

             else
                System.out.println("Seriously? Why so negative?");
        }


    }

}
