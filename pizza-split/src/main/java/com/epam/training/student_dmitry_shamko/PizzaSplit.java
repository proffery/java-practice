package com.epam.training.student_dmitry_shamko;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner scan =new Scanner(System.in);
        int people = scan.nextInt();
        int pizzaPieces = scan.nextInt();
        int pizzaNum;

        for (pizzaNum = 1; pizzaNum * pizzaPieces % people != 0 ;pizzaNum++);{
            System.out.println(pizzaNum);
        }


    }
}
