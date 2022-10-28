package com.ps.JuniorTrainingSheetSolutions;

import java.util.Scanner;
class VanyaAndFence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String b = input.nextLine();
        int r = a.toLowerCase().compareToIgnoreCase(b), result = 0;
        if (r > 0) result = 1;
        else if (r < 0) result = -1;
        System.out.println(result);
        input.close();
    }

}