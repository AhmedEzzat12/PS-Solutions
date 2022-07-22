package com.ps;

import java.util.*;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    //https://leetcode.com/problems/design-hashmap/
    public static void main(String[] args) {
        Thread t1 = new Thread(new Main().new RunnableImpl());
        t1.start();
    }

    private class RunnableImpl implements Runnable {

        public void run() {
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.put(1, 1);
            System.out.println(myHashMap);
            myHashMap.put(2, 2);
            System.out.println(myHashMap);
            System.out.println(myHashMap.get(1));
            System.out.println(myHashMap.get(3));
            myHashMap.put(2, 1);
            System.out.println(myHashMap);
            System.out.println(myHashMap.get(2));
            myHashMap.remove(2);
            System.out.println(myHashMap);
        }
    }


    class MyHashMap {
        LinkedList<Entry>[] listOfEntries;
        private int size = 0;
        private int length = 1;

        public MyHashMap() {
            listOfEntries = new LinkedList[length];
//            for (int i = 0; i < length; i++) {
//                listOfEntries[i] = new LinkedList<Entry>();
//            }
        }

        public void put(int key, int value) {
            if (size == length) {
                length = length << 2;
                listOfEntries = Arrays.copyOf(listOfEntries, length);
            }
            int keyHashedValue = getHashedKey(key);
            if (listOfEntries[keyHashedValue] == null) {
                listOfEntries[keyHashedValue] = new LinkedList<>();
            } else {
                LinkedList<Entry> listOfEntry = listOfEntries[keyHashedValue];
                for (int i = 0; i < listOfEntry.size(); i++) {
                    Entry entry = listOfEntry.get(i);
                    if (entry.getKey() == key) {
                        listOfEntry.set(i, new Entry(key, value));
                        return;
                    }
                }
            }
            listOfEntries[keyHashedValue].add(new Entry(key, value));
            ++size;
        }

        public int get(int key) {
            int keyHashedValue = getHashedKey(key);
            LinkedList<Entry> listOfEntry = listOfEntries[keyHashedValue];
            if (listOfEntry == null) return -1;
            for (Entry entry : listOfEntry) {
                if (entry.getKey() == key) {
                    return entry.getValue();
                }
            }
            return -1;
        }

        public int getHashedKey(int originalKey) {
            return originalKey % length;
        }

        public void remove(int key) {
            int keyHashedValue = getHashedKey(key);
            LinkedList<Entry> listOfEntry = listOfEntries[keyHashedValue];
            if (listOfEntry != null) {
                for (Iterator<Entry> iterator = listOfEntry.iterator(); iterator.hasNext(); ) {
                    Entry entry = iterator.next();
                    if (entry.getKey() == key) {
                        iterator.remove();
                        break;
                    }
                }
                if (listOfEntry.size() == 0) {
                    listOfEntries[keyHashedValue] = null;
                    --size;
                }
            }
        }

        @Override
        public String toString() {
            return "MyHashMap{" +
                    "listOfEntries=" + Arrays.toString(listOfEntries) +
                    '}';
        }
    }

    class Entry {
        private int key;
        private int value;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}