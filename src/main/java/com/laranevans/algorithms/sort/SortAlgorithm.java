package com.laranevans.algorithms.sort;

/**
 * Standard interface for all types of sort.
 *
 * @param <V>
 */
public interface SortAlgorithm<V extends Comparable> {
	void sort(V[] input);
}
