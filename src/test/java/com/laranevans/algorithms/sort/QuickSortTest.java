/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testSortIntegersWithNoDuplicates() {
		QuickSort sorter = new QuickSort();
		Integer[] input = new Integer[] {2, 5, 3, 7, 9, 6};
		sorter.sort(input);
		Assert.assertThat(input, Matchers.equalTo(new Integer[] {2, 3, 5, 6, 7, 9}));
	}

	@Test
	public void testSortIntegersWithDuplicates() {
		QuickSort sorter = new QuickSort();
		Integer[] input = new Integer[] {2, 5, 3, 7, 9, 6, 3};
		sorter.sort(input);
		Assert.assertThat(input, Matchers.equalTo(new Integer[] {2, 3, 3, 5, 6, 7, 9}));
	}

}
