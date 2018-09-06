/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * Merge sort that supports both top-down and bottom-up approaches.
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable> {

	static class TopDownHelper<T extends Comparable> {

		void sortTopDown(T[] origin) {
			if (Objects.isNull(origin) || origin.length < 2)
				return;

			// Split the list in half
			int mid = origin.length / 2;

			// System.arraycopy would be an alternative way to do this
			T[] left = Arrays.copyOfRange(origin, 0, mid);
			T[] right = Arrays.copyOfRange(origin, mid, origin.length);

			// Sort each half
			sortTopDown(left);
			sortTopDown(right);

			// Merge the results
			mergeTopDown(left, right, origin);
		}

		private void mergeTopDown(T[] left, T[] right, T[] origin) {
			int iLeft = 0, iRight = 0, iOrigin = 0;
			while (iLeft < left.length && iRight < right.length) {
				if (left[iLeft].compareTo(right[iRight]) < 1) {
					origin[iOrigin++] = left[iLeft++];
				} else {
					origin[iOrigin++] = right[iRight++];
				}
			}
			while (iLeft < left.length) {
				origin[iOrigin++] = left[iLeft++];
			}
			while (iRight < right.length) { // this was left.length
				origin[iOrigin++] = right[iRight++];
			}
		}
	}

	static class BottomUpHelper<T extends Comparable> {
		// Bottom-up approach

		void sortBottomUp(T[] origin) {
			if (Objects.isNull(origin))
				return;

			int n = origin.length;
			T[] aux = (T[]) new Comparable[n];
			for (int len = 1; len < n; len *= 2) {
				for (int lo = 0; lo < n - len; lo += len*2) {
					mergeBottomUp(origin, aux, lo, lo + len - 1, Math.min(lo + len + len -1, n - 1));
				}
			}

		}

		private void mergeBottomUp(T[] a, T[] aux, int lo, int mid, int hi) {
			for (int k = lo; k <= hi; k++) {
				aux[k] = a[k];
			}

			int i = lo, j = mid+1;
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

	private BottomUpHelper<T> bottomUpHelper = new BottomUpHelper<>();
	private TopDownHelper<T> topDownHelper = new TopDownHelper<>();

	private boolean isSorted(T[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i].compareTo(values[i-1]) < 0) {
				return false;
			}
		}
		return true;
	}

	public void sort(T[] origin) {
		// Sort top-down by default. It's more standard.
		sort(origin, true);
	}
	
	public void sort(T[] origin, boolean topDown) {
		if (topDown) {
			topDownHelper.sortTopDown(origin);
		} else {
			bottomUpHelper.sortBottomUp(origin);
		}

		assert isSorted(origin);
		System.out.println(String.format("Sorted result: %s", Arrays.toString(origin)));
	}

}
