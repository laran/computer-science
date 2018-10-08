/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

/**
 * Three different solutions to the Egg Drop problem.
 *   - recursive solution (slowest)
 *   - dynamic programming solution (faster)
 *   - mathematical solution (fastest) (See: https://brilliant.org/wiki/egg-dropping/#a-better-approach)
 */
public class EggDropSolver {

	// This solves for a single answer given a single building with n floors
	// This solves in O(kEggs * nFloors * log(nFloors)) time and O(kEggs * nFloors) space.
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

	// This solves ALL buildings UP TO AND INCLUDING the size of the building we want to solve.
	// This solves in O(kEggs * maxNFloors) time and O(nFloors) space.
	public static int[][] solveWithDP(int maxNFloors, int kEggs) {

		// +1 to use 1-based indexing
		int[][] memo = new int[maxNFloors + 1][kEggs + 1];

		// When we have only one egg we can only solve iteratively.
		// So the worst case always depends on the floor on which the egg breaks.
		for (int floor = 0; floor <= maxNFloors; floor++) {
			memo[floor][0] = 0;
			memo[floor][1] = floor;
		}

		// When the building has only one floor, the worst case is always 1
		for (int numEggs = 1; numEggs <= kEggs; numEggs++) {
			// memo[0][*] is already initialized to 0
			memo[1][numEggs] = 1;
		}

		// Solve the problem for all buildings smaller than nFloors and up to the number of eggs
		// that we ultimately want to solve for.

		// For all buildings with 2 or more floors ...
		for (int nFloors = 2; nFloors <= maxNFloors; nFloors++) {

			// ... and with 2 or more eggs ...
			for (int egg = 2; egg <= kEggs; egg++) {

				// ... follow the same basic algorithm as we used in the recursive method.
				memo[nFloors][egg] = Integer.MAX_VALUE;

				// Solve for all floors
				for (int floor = 1; floor <= nFloors; floor++) {
					int eggBreaksResult = memo[floor - 1][egg - 1];
					int eggDoesNotBreakResult = memo[nFloors - floor][egg];
					int temp = Math.max(eggBreaksResult, eggDoesNotBreakResult) + 1;
					if (temp < memo[nFloors][egg]) {
						memo[nFloors][egg] = temp;
					}
				}
			}
		}

		return memo;
	}
}
