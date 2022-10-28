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
            System.out.println(findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
        }

        /**
         * @param arr
         * @return
         */
        public static int findLength(char[] arr) {
            // TODO: Write your code here
            int sum = 0;
            int windowStart = 0;
            Map<Character, Integer> m = new HashMap<>();
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                m.put(arr[windowEnd], m.getOrDefault(arr[windowEnd], 0) + 1);

                while (m.size() > 2) {
                    m.put(arr[windowStart], m.get(arr[windowStart]) - 1);
                    if (m.get(arr[windowStart]) == 0) {
                        m.remove(arr[windowStart]);
                    }

                    ++windowStart;
                }
                sum = Math.max(sum, windowEnd - windowStart + 1);
            }

            return sum;
        }

    }

}