package com.ps.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfStones = Integer.parseInt(input.nextLine());
        int numOfStonesRemoved = 0;

        String stones = input.nextLine();
        char c = stones.charAt(0);
        for (int i = 1; i < numOfStones; ++i) {
            if (stones.charAt(i) == c) {
                ++numOfStonesRemoved;
            }
            c = stones.charAt(i);
        }
        input.close();

        System.out.println(numOfStonesRemoved);
    }

}
