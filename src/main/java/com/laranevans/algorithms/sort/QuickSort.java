/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

	public void sort(Comparable[] input) {
		sort(input, 0, input.length - 1);
		System.out.println(String.format("Sorted result: %s", Arrays.toString(input)));
	}

	private void sort(Comparable[] input, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int p = partition(input, lo, hi); // partition to identify the pivot
		sort(input, lo, p-1); // sort the lhs
		sort(input, p+1, hi); // sort the rhs
	}

	private int partition(Comparable[] input, int lo, int hi) {
		int i = lo;
		int j = hi + 1;

		// Start by choosing the first element as the initial pivot.
		Comparable value = input[lo];

		while (true) {

			// increment the lhs pointer until we encounter an element >= the pivot
			while (input[++i].compareTo(value) < 0) {
				if (i == hi) {
					break;
				}
			}

			// decrement the rhs pointer until we encounter an element >= the pivot
			while (value.compareTo(input[--j]) < 0) {
				if (j == lo) {
					break;
				}
			}

			// check for when the lhs and rhs pointers cross
			if (i >= j) {
				break;
			}

			// exchange the elements at the lhs and rhs pointers respectively
			swap(input, i, j);

		}

		// Swap the first element into the pivot position.
		swap(input, lo, j);

		// return the pivot position
		return j;
	}

	private void swap(Object[] a, int i, int j) {
		Object o = a[i];
		a[i] = a[j];
		a[j] = o;
	}

}
