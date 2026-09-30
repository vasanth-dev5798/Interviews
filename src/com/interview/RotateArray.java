package com.interview;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {

        int[] arr = {3, 5, 8, 9, 4, 2, 1,6,7,9,11,12,13,14};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to rotate array");
        int n = sc.nextInt();

        n = n % arr.length;
        
        System.out.println(n);

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[(i + n) % arr.length];
        }
        
        // For Right rotation
		/*
		 * for (int i = 0; i < arr.length; i++) { 
		 * result[(i + n) % arr.length] = arr[i];
		 * }
		 */

        System.out.println(Arrays.toString(result));
        sc.close();
    }
}