/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.algorithms.sort;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CountingSortTest {

	@Test
	public void testSortIntsWithNoDuplicates() {
		int[] a = new int[]{2, 5, 3, 7, 9, 6};
		Assert.assertThat(
			new CountingSort().sort(a, 9),
			Matchers.equalTo(new int[]{2, 3, 5, 6, 7, 9}));
	}

	@Test
	public void testSortIntsWithDuplicates() {
		int[] a = new int[]{2, 5, 5, 7, 9, 6};
		Assert.assertThat(
			new CountingSort().sort(a, 9),
			Matchers.equalTo(new int[]{2, 5, 5, 6, 7, 9}));
	}

	@Test
	public void testSortEmptyArray() {
		int[] a = new int[]{};
		Assert.assertThat(
			new CountingSort().sort(a, 0),
			Matchers.equalTo(new int[]{}));
	}

	@Test
	public void testHandlesNullArray() {
		int[] a = new int[]{};
		Assert.assertThat(
			new CountingSort().sort(null, 0),
			Matchers.nullValue());
	}

	@Test
	public void testHandlesNegativeMaxValue() {
		int[] a = new int[]{};
		try {
			new CountingSort().sort(new int[] {1, 2, 3}, -1);
			fail("Negative maxValue should throw IllegalArgumentException");
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue(true);
		}
	}

}
