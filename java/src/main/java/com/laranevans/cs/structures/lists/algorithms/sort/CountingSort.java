/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import com.laranevans.cs.structures.lists.ArrayHelper;

/**
 * Applies only to a array of positive integers in a specific range.
 */
public class CountingSort {

	public int[] sort(int[] a, int maxValue) {
		if (a == null) {
			return null;
		}

		if (a.length < 1) {
			return new int[]{};
		}

		if (maxValue < 0) {
			throw new IllegalArgumentException("maxValue must be positive");
		}

		int[] index = new int[maxValue + 1]; // the +1 is important because the values in a aren't 0-indexed
		for (int i = 0; i < a.length; i++) {
			index[a[i]] += 1;
		}

		int[] sorted = new int[a.length];
		int s = 0; // index to track progress through sorted array
		for (int i = 0; i < index.length; i++) {
			while (index[i] > 0) { // use the value at index[i] as a counter
				sorted[s++] = i;
				index[i] -= 1; // decrement index[i], using it as a counter
			}
		}

		assert ArrayHelper.isSorted(sorted);
		return sorted;
	}
}
