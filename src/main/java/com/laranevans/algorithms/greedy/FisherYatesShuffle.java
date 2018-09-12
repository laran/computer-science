/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.greedy;

import java.util.Random;

public class FisherYatesShuffle {

	private static Random random = new Random();

	private int getRandom(int floor, int ceiling) {
		return random.nextInt((ceiling - floor) + 1) + floor;
	}

	public void shuffle(Object[] a) {
		if (a.length <= 1) {
			return;
		}

		for (int i = 0; i < a.length - 1; i++) {
			int r = getRandom(i, a.length - 1);
			if (r != i) {
				swap(a, i, r);
			}
		}
	}

	protected void swap(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
