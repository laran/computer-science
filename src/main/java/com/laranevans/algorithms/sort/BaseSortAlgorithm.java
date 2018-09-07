/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A base class that provides a few common utility as well as methods to track the operations that sum to the cost of a
 * sort algorithm.
 *
 * The three primitives are:
 *
 * - the number of comparisons (computational complexity)
 * - the number of swaps (computational complexity)
 * - the amount of memory used (space complexity)
 *
 * @param <T>
 */
abstract class BaseSortAlgorithm<T extends Comparable> implements SortAlgorithm<T> {

	final private AtomicInteger comparisons = new AtomicInteger(0);
	final private AtomicInteger swaps = new AtomicInteger(0);

	protected boolean isSorted(T[] values) {
		for (int i = 1; i < values.length; i++) {
			if (isLessThan(values[i], values[i - 1])) {
				return false;
			}
		}
		return true;
	}

	protected boolean isLessThan(T v, T w) {
		comparisons.getAndIncrement();
		return (v.compareTo(w) < 0);
	}

	protected void swap(T[] a, int i, int j) {
		swaps.getAndIncrement();
		T swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	protected void showResults(T[] a) {
		System.out.println(String.format("Sorted result: %s", Arrays.toString(a)));
	}

	public AtomicInteger getComparisons() {
		return comparisons;
	}

	public AtomicInteger getSwaps() {
		return swaps;
	}
}
