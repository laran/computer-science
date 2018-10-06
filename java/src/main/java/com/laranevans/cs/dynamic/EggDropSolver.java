/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import java.util.Arrays;

/**
 *
 */
public class EggDropSolver {

	public static int solveRecursively(int nFloors, int kEggs) {

		// Handle base cases
		if (kEggs == 0) {
			return Integer.MAX_VALUE;
		} else if (kEggs == 1) {
			return nFloors;
		} else if (nFloors == 0) {
			return 0;
		} else if (nFloors == 1) {
			return 1;
		}

		// Initialize to the worst-case because we're going to look for a better answer.
		int min = Integer.MAX_VALUE;

		for (int floor = 1; floor < nFloors; floor++) {
			int eggBreaksResult = solveRecursively(
				floor - 1, // because we know the floor we're searching for is below the current floor
				kEggs - 1 // because we lost an egg
			);
			int eggDoesNotBreakResult = solveRecursively(
				nFloors - floor, // because we know the floor we're searching for is above the current floor
				kEggs // because we did not lose an egg
			);
			int localMinimum = Math.max( // pessimistically assume the worst case
				eggBreaksResult, eggDoesNotBreakResult)
				+ 1 // because we used up a try
				;
			// Remember when we find a better result.
			if (localMinimum < min) {
				min = localMinimum;
			}
		}
		return min;
	}

	public static int solveWithDP(int nFloors, int kEggs) {
		//
		int[][] memo = new int[nFloors + 1][kEggs + 1];

		// When we have only one egg the worst case always depends on the floor on which the egg breaks
		for (int floor = 0; floor <= nFloors; floor++) {
			memo[floor][0] = 0;
			memo[floor][1] = floor;
		}

		// When the building has only one floor, the worst case is always 1
		for (int numEggs = 1; numEggs <= kEggs; numEggs++) {
			memo[1][numEggs] = 1;
		}

		// Solve the problem for all buildings smaller than nFloors

		// For all buildings with 2 or more floors ...
		for (int floor = 1; floor <= nFloors; floor++) {

			// ... and with 2 or more eggs ...
			for (int egg = 2; egg <= kEggs; egg++) {

				// ... follow the same basic algorithm as we used in the recursive method.
				memo[floor][egg] = Integer.MAX_VALUE;

				for (int x = 1; x <= floor; x++) {
					int eggBreaksResult = memo[x - 1][egg - 1];
					int eggDoesNotBreakResult = memo[floor - x][egg];
					int temp = Math.max(eggBreaksResult, eggDoesNotBreakResult) + 1;
					if (temp < memo[floor][egg]) {
						memo[floor][egg] = temp;
					}
				}
			}
		}

		show(memo);

		return memo[nFloors][kEggs];
	}

	public static void show(int[][] memo) {
		for (int i = 0; i < memo.length; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
	}

}
