package com.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerStreams {

    public static void main(String[] args) {
 
    int[] numbers = {1, 2, 3, 4, 5, 4, 6, 2, 3};

    Set<Integer> seen = new HashSet<>();

    List<Integer> duplicates = Arrays.stream(numbers).filter(n -> !seen.add(n)).boxed().collect(Collectors.toList());

    System.out.println("Duplicate numbers: " + duplicates);

    Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
            .stream().filter(e-> e.getValue() > 1).forEach(e -> System.out.print(e.getKey() + " " + e.getValue() + " times, "));
    }
}
