/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

public class QuickSort<T extends Comparable> extends BaseSortAlgorithm<T> {

	@Override
	public void sort(T[] origin) {
		sort(origin, 0, origin.length - 1);

		assert isSorted(origin);
		showResults(origin);
	}

	private void sort(T[] input, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int p = partition(input, lo, hi); // partition to identify the pivot
		sort(input, lo, p - 1); // sort the lhs
		sort(input, p + 1, hi); // sort the rhs
	}

	private int partition(T[] input, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		// Start by choosing the first element as the initial pivot.
		T value = input[lo];

		while (true) {

			// increment the lhs pointer until we encounter an element >= the pivot
			while (isLessThan(input[++i], value)) {
				if (i == hi) {
					break;
				}
			}

			// decrement the rhs pointer until we encounter an element >= the pivot
			while (isLessThan(value, input[--j])) {
				if (j == lo) {
					break;
				}
			}

			// check for when the lhs and rhs pointers cross
			if (i >= j) {
				break;
			}

			// exchange the elements at the lhs and rhs pointers respectively
			swap(input, i, j);

		}

		// Swap the first element into the pivot position.
		swap(input, lo, j);

		// return the pivot position
		return j;
	}

}
