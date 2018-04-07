package com.company;

import java.util.*;

public class Solution {

    public static void main(String args[]) {
        int arr[] = new int[]{8, 2, 2, 2, 2, 1, 1, 1, 1, 4, 4};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int curr : arr)
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

        Map<Integer, ArrayList<Integer>> result = new TreeMap<>();
        freq.forEach((key, value) -> {
            ArrayList<Integer> temp = (result.containsKey(value)) ? result.get(value) : new ArrayList<>();
            for (int i = 0; i < value; i++) {
                temp.add(key);
                result.put(value, temp);
            }
        });

        result.keySet().stream().forEach(x -> {
            ArrayList ttemp = result.get(x);
            Collections.sort(ttemp);
            ttemp.stream().forEach(System.out::println);
        });
    }

}
