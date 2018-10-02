/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

/**
 *
 * @param &lt;V&gt;
 */
public class InsertionSort<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) { // sort from left to right
			int j = i;
			// working from right to left,
			// - shift each element one position to the right until:
			// -- we reach the beginning of the array OR
			// -- the item to the left is less than the element at index j
			// NOTE: It's important to check that j > 0 before comparing a[j] and a[j-1] in order to stay in bounds
			while (j > 0 && isLessThan(a[j], a[j - 1])) {
				swap(a, j, j - 1);
				j--;
			}
		}
		showResults(a);
	}
}
