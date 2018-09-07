/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class MergeSortBottomUpTest {

	@Test
	public void testSortIntegersBottomUp() {
		SortAlgorithm<Integer> sorter = new MergeSortBottomUp<>();
		Integer[] input = new Integer[]{3, 5, 1, 2, 4};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new Integer[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testSortStringsBottomUp() {
		SortAlgorithm<String> sorter = new MergeSortBottomUp<>();
		String[] input = new String[]{"A", "D", "B", "Z", "L"};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new String[] {"A", "B", "D", "L", "Z"}));
	}

}
