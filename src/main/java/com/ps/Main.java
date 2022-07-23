package com.ps;

import java.util.*;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    //https://leetcode.com/problems/lru-cache/
    public static void main(String[] args) {
        Thread t1 = new Thread(new Main().new RunnableImpl());
        t1.start();
    }

    private class RunnableImpl implements Runnable {

        public void run() {

            LRUCache lruCache = new LRUCache(2);
            lruCache.put(1, 1);
            lruCache.put(2, 2);
            lruCache.get(1);
            lruCache.put(3, 3);
            lruCache.get(2);
            lruCache.put(4, 4);
            lruCache.get(1);
            lruCache.get(3);
            lruCache.get(4);
            System.out.println(lruCache);
        }
    }

    class LRUCache {

        Map<Integer, LinkedNode> map;
        LinkedNode head;
        LinkedNode tail;

        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new LinkedNode(0, 0);
            tail = new LinkedNode(0, 0);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        void addToHead(LinkedNode node) {
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                LinkedNode linkedNode = map.get(key);
                removeNode(linkedNode);
                addToHead(linkedNode);
                return map.get(key).value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                LinkedNode linkedNode = map.get(key);
                linkedNode.value = value;
                map.put(key, linkedNode);
                removeNode(linkedNode);
                addToHead(linkedNode);
            } else {
                LinkedNode linkedNode = new LinkedNode(key, value);
                map.put(key, linkedNode);
                if (map.size() > this.capacity) {
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }
                addToHead(linkedNode);
            }
        }
    }

    class LinkedNode {
        int value;
        int key;

        public LinkedNode(int key, int value) {
            this.value = value;
            this.key = key;
        }

        LinkedNode prev;
        LinkedNode next;
    }

}