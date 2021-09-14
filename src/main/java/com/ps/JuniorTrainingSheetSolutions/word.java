package com.ps.JuniorTrainingSheetSolutions;

import java.util.Scanner;

public class word {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] word = input.nextLine().toCharArray();
        int upperCaseCnt = 0;
        for (char c : word) if (Character.isUpperCase(c)) ++upperCaseCnt;
        if (upperCaseCnt > (word.length / 2)) System.out.println(String.valueOf(word).toUpperCase());
        else System.out.println(String.valueOf(word).toLowerCase());
        input.close();
    }
}
