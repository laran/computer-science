/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import java.util.Objects;

/**
 * Merge sort from the bottom-up.
 *
 * @param &lt;V&gt;
 */
public class MergeSortBottomUp<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] origin) {
		if (Objects.isNull(origin))
			return;

		int n = origin.length;
		V[] aux = (V[]) new Comparable[n];
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len * 2) {
				merge(origin, aux, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
			}
		}

		assert isSorted(origin);
		showResults(origin);
	}

	private void merge(V[] a, V[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			set(aux, k, a, k);
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				set(a, k, aux, j++);
			} else if (j > hi) {
				set(a, k, aux, i++);
			} else if (isLessThan(aux[j], aux[i])) {
				set(a, k, aux, j++);
			} else {
				set(a, k, aux, i++);
			}
		}
	}
}
