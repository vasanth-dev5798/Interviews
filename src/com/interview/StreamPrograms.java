package com.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPrograms{

    public static void main(String[] args) {
        // Example usage of Stream API
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Sum of squares of even numbers
        int sumOfSquares = Arrays.stream(numbers)
                                 .filter(n -> n % 2 == 0)
                                 .map(n -> n * n)
                                 .sum();
        
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);

        String input = "Hello World from Stream API";
        // Reverse each word in the string
        String highLengthWord = Arrays.stream(input.split(" "))
                                .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                                 .orElse("");
        System.out.println("Word with highest length: " + highLengthWord);

        String name = "Vasanthakumar";
        Map<Character, Long> charCountMap = name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Character count in the name: " + charCountMap);

    
    }
}