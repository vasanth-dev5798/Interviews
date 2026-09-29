package com.interview;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntArrayProblem {
	
	public static void main(String[] args) {
		
		int[] arr = {16, 17, 17, 3, 4, 3, 5, 2};
		
		
		for(int i =0;i<arr.length;i++) {
			boolean check = true;

			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[j] >= arr[i]) {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.println("The Indices are "+ i);
			}
			
		}
		
		String str = "Java code guide";
		
		String res = Arrays.stream(str.split(" ")).
		map(s->new StringBuilder(s).reverse()).collect(Collectors.joining(" ")).toString();
		
		System.out.println(res);
		/*
		 * int rightmax = Integer.MIN_VALUE;
		 * 
		 * for(int i = arr.length-1; i>=0;i--) {
		 * 
		 * if(arr[i]>rightmax) { System.out.println("Indices are : "+i); rightmax =
		 * arr[i]; }
		 * 
		 * }*/
		
		int[] zarr = {0,1,0,2,0,3,0,0};
		
		int[] zres = new int[zarr.length];
		int t=0;
		
		for(int i =0;i<zarr.length;i++) {
			
			if(zarr[i]!=0) {
				zres[t] = zarr[i];
				t++;
			}
		}
		
		while(t<zarr.length) {
			zres[t]=0;
			t++;
		}
		System.out.println(Arrays.toString(zres));
		
	    Arrays.stream(zarr).max().ifPresent(System.out::println);
	    
	    int[] rarr = {3, 5, 7, 9, 4, 1};
	    int r = 3;
	    int[] res1 = new int[rarr.length];
	    r=r%rarr.length-1;
	    for (int i=0;i<rarr.length;i++) {
	    	res1[i] = rarr[(i+r)%rarr.length];
	    }
	    
	    System.out.println("Left Rotation - "+Arrays.toString(res1));
	    
	    int[] res2 = new int[rarr.length];
	    for (int i=0;i<rarr.length;i++) {
	    	res2[(i+r)%rarr.length] = rarr[i];
	    }
	    
	    System.out.println("Right Rotation - "+Arrays.toString(res2));
	    
	    
	    }

}
