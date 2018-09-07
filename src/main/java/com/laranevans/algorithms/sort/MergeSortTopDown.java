/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * Merge sort from the top-down.
 *
 * @param <V>
 */
public class MergeSortTopDown<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] a) {
		doSort(a);

		assert isSorted(a);
		showResults(a);
	}

	private void doSort(V[] a) {
		if (Objects.isNull(a) || a.length < 2)
			return;

		// Split the list in half
		int mid = a.length / 2;

		// System.arraycopy would be an alternative way to do this
		V[] left = Arrays.copyOfRange(a, 0, mid);
		V[] right = Arrays.copyOfRange(a, mid, a.length);

		// SortAlgorithm each half
		doSort(left);
		doSort(right);

		// Merge the results
		merge(left, right, a);
	}

	private void merge(V[] left, V[] right, V[] a) {
		int iLeft = 0, iRight = 0, iA = 0;
		while (iLeft < left.length && iRight < right.length) {
			if (isLessThanOrEqualTo(left[iLeft], right[iRight])) {
				set(a, iA++, left, iLeft++);
			} else {
				set(a, iA++, right, iRight++);
			}
		}
		while (iLeft < left.length) {
			set(a, iA++, left, iLeft++);;
		}
		while (iRight < right.length) {
			set(a, iA++, right, iRight++);
		}
	}
}
