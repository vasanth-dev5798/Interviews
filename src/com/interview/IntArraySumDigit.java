package com.interview;

import java.util.Scanner;

public class IntArraySumDigit {

    public static void main(String[] args) {
        int[] arr = { 2, 7, 8, 3, 4, 5 };
        System.out.println("Enter number : ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        checkDigits(arr, k);
        sc.close();
    }

    public static void checkDigits(int[] iarr, int n) {
        for (int i = 0; i < iarr.length; i++) {
            for (int j = i + 1; j < iarr.length; j++) {
                if (iarr[i] + iarr[j] == n) {
                    System.out.println(iarr[i] + " , " + iarr[j]);
                }
            }
        }
    }

}
