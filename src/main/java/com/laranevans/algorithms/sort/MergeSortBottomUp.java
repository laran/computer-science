/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * Merge sort from the bottom-up.
 * Does not use static methods so that generics can be utilized.
 *
 * @param <T>
 */
public class MergeSortBottomUp<T extends Comparable> extends BaseSortAlgorithm<T> {

	@Override
	public void sort(T[] origin) {
		if (Objects.isNull(origin))
			return;

		int n = origin.length;
		T[] aux = (T[]) new Comparable[n];
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len * 2) {
				merge(origin, aux, lo, lo + len - 1, Math.min(lo + len + len - 1, n - 1));
			}
		}

		assert isSorted(origin);
		showResults(origin);
	}

	private void merge(T[] a, T[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (aux[j].compareTo(aux[i]) < 0) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
}
