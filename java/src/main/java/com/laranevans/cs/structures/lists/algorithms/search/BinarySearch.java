/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.search;

import com.laranevans.cs.algorithms.BaseAlgorithm;

import java.util.Objects;

/**
 *
 * @param &lt;V&gt;
 */
public class BinarySearch <V extends Comparable> extends BaseAlgorithm<V> {

	public int search(V[] a, V o) {
		return search(a, o, 0, a.length - 1);
	}

	private int search(V[] a, V o, int lo, int hi) {
		if (Objects.isNull(a)) {
			throw new IllegalArgumentException("Cannot search a null array");
		}

		if (a.length == 0) {
			return -1;
		}

		// Find the mid-point
		int i = lo + ((hi - lo) / 2);

		// If the element at the midpoint matches, we're done.
		if (isEqualTo(o, a[i])) {
			return i;
		}

		// If the element at the midpoint is larger that the target, recurse to search the left half ...
		if (isGreaterThan(a[i], o)) {
			return search(a, o, lo, i);
		}

		// ... otherwise, search the right half
		return search(a, o, i+1, hi);
	}

}
