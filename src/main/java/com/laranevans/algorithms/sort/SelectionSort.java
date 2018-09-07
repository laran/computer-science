/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

public class SelectionSort<V extends Comparable> extends BaseSortAlgorithm<V> {

	@Override
	public void sort(V[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int m = i; // index of the minimum value greater than a[i]
			for (int j = i+1; j < n; j++) {
				if (isLessThan(a[j], a[m])) {
					m = j;
				}
			}
			swap(a, i, m);
		}
		showResults(a);
	}
}