package com.interview;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MedianNumber {

    public static void main(String[] args) {

        int[] num1 = {1, 2, 3,8};
        int[] num2 = {4, 5, 6,7};

        int[] sorted = IntStream.concat(Arrays.stream(num1), Arrays.stream(num2))
                .sorted().toArray();

        int length = sorted.length;
        double result = 0;

        if (length % 2 != 0) {
            result = sorted[length / 2];
        } else {
            int n1 = sorted[(length / 2) - 1];
            int n2 = sorted[length / 2];
            result = ((n1 + n2) / 2.0);
        }
        System.out.println("Median Number - "+result);
    }
}
