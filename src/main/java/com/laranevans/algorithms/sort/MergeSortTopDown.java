/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * Merge sort from the top-down.
 * Does not use static methods so that generics can be utilized.
 *
 * @param <T>
 */
public class MergeSortTopDown<T extends Comparable> extends BaseSortAlgorithm<T> {

	@Override
	public void sort(T[] origin) {
		doSort(origin);

		assert isSorted(origin);
		showResults(origin);
	}

	private void doSort(T[] origin) {
		if (Objects.isNull(origin) || origin.length < 2)
			return;

		// Split the list in half
		int mid = origin.length / 2;

		// System.arraycopy would be an alternative way to do this
		T[] left = Arrays.copyOfRange(origin, 0, mid);
		T[] right = Arrays.copyOfRange(origin, mid, origin.length);

		// SortAlgorithm each half
		doSort(left);
		doSort(right);

		// Merge the results
		merge(left, right, origin);
	}

	private void merge(T[] left, T[] right, T[] origin) {
		int iLeft = 0, iRight = 0, iOrigin = 0;
		while (iLeft < left.length && iRight < right.length) {
			if (left[iLeft].compareTo(right[iRight]) < 1) {
				origin[iOrigin++] = left[iLeft++];
			} else {
				origin[iOrigin++] = right[iRight++];
			}
		}
		while (iLeft < left.length) {
			origin[iOrigin++] = left[iLeft++];
		}
		while (iRight < right.length) { // this was left.length
			origin[iOrigin++] = right[iRight++];
		}
	}
}
