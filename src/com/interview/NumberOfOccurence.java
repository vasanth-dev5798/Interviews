package com.interview;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberOfOccurence {
    
        public static void main(String[] args){

        int[] arr = {1,1,1,2,2,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7};
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(e->e.getValue()>=k).forEach(System.out::print);
        
        sc.close();
    }
}
