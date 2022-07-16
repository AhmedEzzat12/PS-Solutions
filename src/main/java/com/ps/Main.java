package com.ps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (intMap.containsKey(complement)) {
                return new int[]{intMap.get(complement), i};
            }
            intMap.put(nums[i], i);
        }


        return null;
    }

}