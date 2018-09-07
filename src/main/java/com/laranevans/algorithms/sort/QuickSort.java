/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

public class QuickSort<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] a) {
		sort(a, 0, a.length - 1);

		assert isSorted(a);
		showResults(a);
	}

	private void sort(V[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int p = partition(a, lo, hi); // partition to identify the pivot
		sort(a, lo, p - 1); // sort the lhs
		sort(a, p + 1, hi); // sort the rhs
	}

	private int partition(V[] a, int lo, int hi) {
		int i = lo; // the lhs index
		int ip = hi + 1; // the pivot index

		// Start by choosing the first element as the initial pivot.
		V pivot = a[lo];

		while (true) {

			// increment the lhs pointer until we encounter an element >= the pivot
			while (isLessThan(a[++i], pivot)) {
				if (i >= hi) {
					break;
				}
			}

			// decrement the rhs pointer until we encounter an element >= the pivot
			while (isLessThan(pivot, a[--ip])) {
				if (ip <= lo) {
					break;
				}
			}

			// we're done when the lhs and rhs pointers cross
			if (i >= ip) {
				break;
			}

			// exchange the elements at the lhs and rhs pointers respectively
			swap(a, i, ip);

		}

		// Swap the first element into the pivot position.
		swap(a, lo, ip);

		// return the pivot position
		return ip;
	}

}
