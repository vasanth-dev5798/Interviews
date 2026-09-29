package com.interview;

public class IslandProblem {

	public static void main(String[] args) {
		int[][] numArr = { 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 }};

		System.out.println("Number of Island - " + getIslands(numArr));

	}

	private static int getIslands(int[][] intArr) {
		int island = 0;
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 0; j < intArr.length; j++) {
				if (intArr[i][j] == 1) {
					doDfs(intArr, i, j);
					island++;
				}
			}
		}
		return island;
	}

	private static void doDfs(int[][] arrint, int i, int j) {
		if (arrint[i][j] == 0) {
			return;
		}

		arrint[i][j] = 0;
		if (i > 0) {
			doDfs(arrint, i - 1, j);
		}
		if (j > 0) {
			doDfs(arrint, i, j - 1);
		}
		if (i < arrint.length - 1) {
			doDfs(arrint, i + 1, j);
		}
		if (j < arrint.length - 1) {
			doDfs(arrint, i, j + 1);
		}

	}
}
