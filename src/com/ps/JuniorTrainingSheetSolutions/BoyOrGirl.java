package com.ps.JuniorTrainingSheetSolutions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyOrGirl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < userName.length(); ++i) charSet.add(userName.charAt(i));
        System.out.println(charSet.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
        input.close();
    }
}
