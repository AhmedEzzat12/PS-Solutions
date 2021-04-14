package com.ps.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfCards = Integer.parseInt(input.nextLine());
        int firstSum = 0, secondSum = 0;

        String cards = input.nextLine();

        if (numOfCards == 1) {
            System.out.println(cards + " " + secondSum);
            return;
        }
        Integer[] numbers = Arrays.stream(cards.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        LinkedList<Integer> integerLinkedList = new LinkedList<>(Arrays.asList(numbers));

        int integerLinkedListSize = integerLinkedList.size();
        for (int i = 0; i < integerLinkedListSize; ++i) {
            int biggerNum;
            if (integerLinkedList.getLast() > integerLinkedList.getFirst()) {
                biggerNum = integerLinkedList.getLast();
                integerLinkedList.removeLast();
            } else {
                biggerNum = integerLinkedList.getFirst();
                integerLinkedList.removeFirst();
            }
            if (i % 2 == 0) {
                firstSum += biggerNum;
            } else secondSum += biggerNum;
        }
        input.close();
        System.out.println(firstSum + " " + secondSum);

    }

}
