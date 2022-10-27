package com.ps;

import java.util.*;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableImpl());
        t1.start();
    }

    private static class RunnableImpl implements Runnable {

        public void run() {
            System.out.println(solution(new int[] { 2, 1, 5, 2, 3, 2 }, 7));
        }

        public int solution(int[] arr, int S) {
            int windowStart = 0;
            int sum = 0;
            int smallestLength = Integer.MAX_VALUE;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                sum += arr[windowEnd];

                if (sum >= S) {
                    while (sum >= S) {
                        smallestLength = Math.min(windowEnd - windowStart + 1, smallestLength);
                        sum -= arr[windowStart];
                        ++windowStart;
                    }
                }
            }
            return smallestLength;
        }

    }

}