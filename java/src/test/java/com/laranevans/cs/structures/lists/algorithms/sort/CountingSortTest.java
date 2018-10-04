/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Counting Sort")
public class CountingSortTest {

	@Test
	public void shouldSortAnArrayOfIntsWithoutDuplicates() {
		int[] a = new int[]{2, 5, 3, 7, 9, 6};
		assertThat(
			new CountingSort().sort(a, 9),
			Matchers.equalTo(new int[]{2, 3, 5, 6, 7, 9}));
	}

	@Test
	public void shouldSortAnArrayOfIntsWithDuplicates() {
		int[] a = new int[]{2, 5, 5, 7, 9, 6};
		assertThat(
			new CountingSort().sort(a, 9),
			Matchers.equalTo(new int[]{2, 5, 5, 6, 7, 9}));
	}

	@Test
	public void shouldHandleAnEmptyArray() {
		int[] a = new int[]{};
		assertThat(
			new CountingSort().sort(a, 0),
			Matchers.equalTo(new int[]{}));
	}

	@Test
	public void shouldHandleANullArray() {
		int[] a = new int[]{};
		assertThat(
			new CountingSort().sort(null, 0),
			Matchers.nullValue());
	}

	@Test
	public void shouldHandleANegativeMaxValue() {
		int[] a = new int[]{};
		try {
			new CountingSort().sort(new int[]{1, 2, 3}, -1);
			fail("Negative maxValue should throw IllegalArgumentException");
		} catch (IllegalArgumentException iae) {
			assertTrue(true);
		}
	}
}
