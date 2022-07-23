package com.ps;

import java.util.*;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    //https://leetcode.com/problems/insert-delete-getrandom-o1/
    public static void main(String[] args) {
        Thread t1 = new Thread(new Main().new RunnableImpl());
        t1.start();
    }

    private class RunnableImpl implements Runnable {

        public void run() {
        }
    }

    class RandomizedSet {

        Map<Integer, Integer> nodes;

        public RandomizedSet() {
            nodes = new HashMap<>();
        }

        public boolean insert(int val) {
            if (nodes.get(val) == null) {
                nodes.put(val, val);
                return true;
            } else {
                return false;
            }
        }

        public boolean remove(int val) {
            if (!nodes.containsKey(val)) {
                return false;
            } else {
                nodes.remove(val);
                return true;
            }
        }

        public int getRandom() {
            List<Integer> integers = nodes.values().stream().toList();
            return integers.get((int) ((Math.random() * (integers.size() - 0)) + 0));
        }
    }

}