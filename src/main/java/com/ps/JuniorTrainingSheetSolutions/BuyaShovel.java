package com.ps.JuniorTrainingSheetSolutions;

import java.util.Scanner;

public class BuyaShovel {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] s1 = s.split(" ");
        int c = 1;
        int price = Integer.parseInt(s1[0]);
        int newPrice = price;
        int change = Integer.parseInt(s1[1]);
        while (newPrice % 10 != 0 && newPrice % 10 != change) {
            ++c;
            newPrice = price * c;
        }
        System.out.println(c);
    }
}
