package com.laranevans.cs.algorithms.sort;

/**
 * Standard interface for all types of sort.
 *
 * @param &lt;V&gt;
 */
public interface SortAlgorithm<V extends Comparable> {
	void sort(V[] a);
}
