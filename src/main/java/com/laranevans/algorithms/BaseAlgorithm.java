/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A base class that provides a few common utility as well as methods to track the
 * operations that sum to the cost of an algorithm.
 * <p>
 * The three primitives are:
 * <p>
 * - the number of comparisons (computational complexity)
 * - the number of swaps (computational complexity)
 * - the amount of memory used (space complexity)
 * <p>
 * In-place algorithms use swaps.
 * Algorithms that use additional memory don't swap. Instead they "set" values in temp storage.
 * So "sets" and "swaps" are tracked separately.
 *
 * @param <V>
 */
public abstract class BaseAlgorithm<V extends Comparable> {

	// static so random seed is common to all algorithms
	private static Random random = new Random();

	final private AtomicInteger comparisons = new AtomicInteger(0);
	final private AtomicInteger swaps = new AtomicInteger(0);
	final private AtomicInteger sets = new AtomicInteger(0);

	public void showResults(V[] a) {
		System.out.println(String.format(
			"Comparisons: %s, Swaps: %s, Sets: %s, Sorted Result: %s",
			this.comparisons.get(),
			this.swaps.get(),
			this.sets.get(),
			Arrays.toString(a)
		));
	}

	protected boolean isSorted(V[] values) {
		for (int i = 1; i < values.length; i++) {
			if (isLessThan(values[i], values[i - 1])) {
				return false;
			}
		}
		return true;
	}

	protected boolean isLessThan(V lhs, V rhs) {
		comparisons.getAndIncrement();
		return (lhs.compareTo(rhs) < 0);
	}

	protected boolean isGreaterThan(V lhs, V rhs) {
		comparisons.getAndIncrement();
		return (lhs.compareTo(rhs) > 0);
	}

	protected boolean isEqualTo(V lhs, V rhs) {
		comparisons.getAndIncrement();
		return (lhs.compareTo(rhs) == 0);
	}

	protected boolean isLessThanOrEqualTo(V lhs, V rhs) {
		comparisons.getAndIncrement();
		return (lhs.compareTo(rhs) < 1);
	}

	protected boolean isGreaterThanOrEqualTo(V lhs, V rhs) {
		comparisons.getAndIncrement();
		return (lhs.compareTo(rhs) > -1);
	}

	protected void swap(V[] a, int i, int j) {
		swaps.getAndIncrement();
		V swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	protected void set(V[] sink, int iSink, V[] source, int iSource) {
		sets.getAndIncrement();
		sink[iSink] = source[iSource];
	}

	protected int getRandom(int floor, int ceiling) {
		return random.nextInt((ceiling - floor) + 1) + floor;
	}

	public AtomicInteger getComparisons() {
		return comparisons;
	}

	public AtomicInteger getSwaps() {
		return swaps;
	}

	public AtomicInteger getSets() {
		return sets;
	}
}
