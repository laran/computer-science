/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists;

public class ArrayHelper {

	/**
	 * Swap a[i] and a[j]
	 *
	 * @param a
	 * @param i
	 * @param j
	 */
	public static void swap(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void swap(boolean[] a, int i, int j) {
		boolean c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(byte[] a, int i, int j) {
		byte c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(double[] a, int i, int j) {
		double c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(float[] a, int i, int j) {
		float c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(long[] a, int i, int j) {
		long c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	public static void swap(short[] a, int i, int j) {
		short c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

	/**
	 * Replace element iSink of sink[] with element iSource of source[].
	 *
	 * @param sink
	 * @param iSink
	 * @param source
	 * @param iSource
	 */
	public static void set(Object[] sink, int iSink, Object[] source, int iSource) {
		sink[iSink] = source[iSource];
	}

	/**
	 * @param values
	 * @param <V>
	 * @return
	 */
	public static <V extends Comparable> boolean isSorted(V[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i].compareTo(values[i - 1]) < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(byte[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(char[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(double[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(float[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(int[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(long[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(short[] values) {
		for (int i = 1; i < values.length; i++) {
			if (values[i] < values[i - 1]) {
				return false;
			}
		}
		return true;
	}

}
