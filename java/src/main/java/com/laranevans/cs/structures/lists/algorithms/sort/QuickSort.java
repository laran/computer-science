/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

/**
 *
 * @param &lt;V&gt;
 */
public class QuickSort<V extends Comparable> extends BaseSortAlgorithm<V> {

	/**
	 *
	 * @param a
	 */
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
		int p = lo; // the pivot index

		for (int i = lo; i < hi; i++) {
			if (isLessThan(a[i], a[hi])) {
				swap(a, i, p++);
			}
		}
		swap(a, hi, p);
		return p;
	}

}
