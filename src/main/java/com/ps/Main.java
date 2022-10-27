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
            System.out.println(solution(new int[] { 2, 1, 5, 1, 3, 2 }, 3));
        }

        public int solution(int[] arr, int k) {
            int windowStart = 0;
            int maxSum = 0;
            int sum = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                sum += arr[windowEnd];
                maxSum = Math.max(maxSum, sum);
                if (windowEnd - windowStart + 1 == k) {
                    sum -= arr[windowStart];
                    ++windowStart;
                }
            }
            return maxSum;
        }

    }

}