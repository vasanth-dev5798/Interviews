package com.interview;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaProgram {

    public static void main(String[] args) {

        String s = "abcdabdprrps";

        s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).findFirst().ifPresent(System.out::println);

        int[] arr = { 78, 76, 80, 83, 86, 84, 88, 90, 87, 90, 88 };

        int buyPrice = Integer.MAX_VALUE;
        int buyIndex = 0;
        int sellPrice = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] < buyPrice) {
                buyPrice = arr[i];
                buyIndex = i;
            }
        }

        for (int j = buyIndex; j < arr.length; j++) {
            if (arr[j] > sellPrice) {
                sellPrice = arr[j];
            }

        }

        System.out.println(buyPrice + " , " + sellPrice);

    }

}
