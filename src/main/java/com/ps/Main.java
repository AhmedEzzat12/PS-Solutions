package com.ps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        Map<String, Long> collect = strings
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String query : queries) {
            Long aLong = collect.getOrDefault(query, 0L);
            res.add(Math.toIntExact(aLong));
        }
        return res;
    }
}