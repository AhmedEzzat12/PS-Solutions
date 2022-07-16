package com.ps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        merge(new int[]{0}, 0
                , new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalLength = m + n;
        int x = 0;
        for (int i = m; i < totalLength; i++) {
            nums1[i] = nums2[x];
            ++x;
        }
        bubbleSort(nums1, totalLength);
        System.out.println(Arrays.toString(nums1));
    }

    public static void bubbleSort(int[] sort_arr, int len) {

        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - i - 1; ++j) {
                if (sort_arr[j + 1] < sort_arr[j]) {
                    int swap = sort_arr[j];
                    sort_arr[j] = sort_arr[j + 1];
                    sort_arr[j + 1] = swap;

                }
            }
        }
    }

}