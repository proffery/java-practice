package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hh = 0;
        int mm = 0;
        int ss = 0;
        hh = seconds / 3600;
        if (hh >= 24)
            hh = 0;
        mm = seconds / 60 % 60;
        ss = seconds % 60;
        if ((ss >= 0 && ss < 10) && (mm >= 0 && mm < 10))
            System.out.println(hh + ":0" + mm + ":0" + ss);
        else
        {
            if (ss >= 0 && ss < 10)
                System.out.println(hh + ":" + mm + ":0" + ss);
            else {

                if ((mm >= 0 && mm < 10))
                    System.out.println(hh + ":0" + mm + ":" + ss);


                else
                    System.out.println(hh + ":" + mm + ":" + ss);
            }


        }

    }
}
