package com.epam.rd.autotasks.godutch;
import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scan = new Scanner(System.in);
        int inCost = scan.nextInt();
        int inFriends = scan.nextInt();
        if (inCost < 0) {
            System.out.print("Bill total amount cannot be negative");
        }
        else {

            if (inFriends <= 0)
                System.out.print("Number of friends cannot be negative or zero");
            else {
                int payByOne = (int) (1.1 * inCost  / inFriends);
                System.out.print(payByOne);
            }
        }
    }
}
