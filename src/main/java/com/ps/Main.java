package com.ps;

import java.util.*;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    //https://leetcode.com/problems/min-stack/
    public static void main(String[] args) {
        Thread t1 = new Thread(new Main().new RunnableImpl());
        t1.start();
    }

    private class RunnableImpl implements Runnable {

        public void run() {
        }
    }

    class MinStack {
        Node head;

        public void push(int val) {
            if (head == null) {
                head = new Node(val, null, val);
            } else {
                head = new Node(val, head, Math.min(val, head.min));
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }
    }

    class Node {
         int value;
         Node next;
         int min;

        public Node(int value, Node next, int min) {
            this.value = value;
            this.next = next;
            this.min = min;
        }
    }
}