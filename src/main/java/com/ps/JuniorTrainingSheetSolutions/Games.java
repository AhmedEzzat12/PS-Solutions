package com.ps.JuniorTrainingSheetSolutions;

import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTeams = Integer.parseInt(input.nextLine());
        int[] hosts = new int[numOfTeams];
        int[] guests = new int[numOfTeams];
        int counter = 0;
        for (int i = 0; i < numOfTeams; ++i) {
            String s = input.nextLine();
            String[] s1 = s.split(" ");
            hosts[i] = Integer.parseInt(s1[0]);
            guests[i] = Integer.parseInt(s1[1]);
        }

        for (int i = 0; i < numOfTeams; ++i) {
            for (int j = 0; j < numOfTeams; j++) {
                if (i == j) continue;
                if (guests[j] == hosts[i]) ++counter;
            }
        }
        System.out.println(counter);
    }

}
