/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class MergeSortTopDownTest {

	@Test
	public void testSortIntegersTopDown() {
		MergeSortTopDown<Integer> sorter = new MergeSortTopDown<>();
		Integer[] input = new Integer[]{3, 5, 1, 2, 4};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new Integer[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testSortStringsTopDown() {
		MergeSortTopDown<String> sorter = new MergeSortTopDown<>();
		String[] input = new String[]{"A", "D", "B", "Z", "L"};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new String[] {"A", "B", "D", "L", "Z"}));
	}

}
