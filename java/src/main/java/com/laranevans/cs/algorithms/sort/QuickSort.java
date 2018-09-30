/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.algorithms.sort;

/**
 * This is an implementation of QuickSort algorithm as presented in The Algorithm Design Manual by
 * Steven Skiena. This version is shorter and easier to remember than the previous version I wrote
 * (see the version history on this file for the previous algorithm).
 *
 * @param <V>
 */
public class QuickSort<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] a) {
		sort(a, 0, a.length - 1);

		assert isSorted(a);
		showResults(a);
	}

	private void sort(V[] a, int lo, int hi) {
		if ((hi-lo) > 0) {
			int p = partition(a, lo, hi); // partition to identify the pivot
			sort(a, lo, p - 1); // sort the lhs
			sort(a, p + 1, hi); // sort the rhs
		}
	}

	private int partition(V[] a, int lo, int hi) {
		int p = hi;
		int fh = lo; // the pivot index

		for (int i = lo; i < hi; i++) {
			if (isLessThan(a[i], a[p])) {
				swap(a, i, fh++);
			}
		}
		swap(a, p, fh);
		return fh;
	}

}
