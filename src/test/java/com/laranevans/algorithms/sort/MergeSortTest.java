/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class MergeSortTest {

	@Test
	public void testSortIntegersTopDown() {
		MergeSort<Integer> sorter = new MergeSort<>();
		Integer[] input = new Integer[]{3, 5, 1, 2, 4};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new Integer[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testSortStringsTopDown() {
		MergeSort<String> sorter = new MergeSort<>();
		String[] input = new String[]{"A", "D", "B", "Z", "L"};
		sorter.sort(input);
		Assert.assertThat(input, equalTo(new String[] {"A", "B", "D", "L", "Z"}));
	}

	@Test
	public void testSortIntegersBottomUp() {
		MergeSort<Integer> sorter = new MergeSort<>();
		Integer[] input = new Integer[]{3, 5, 1, 2, 4};
		sorter.sort(input,false);
		Assert.assertThat(input, equalTo(new Integer[] {1, 2, 3, 4, 5}));
	}

	@Test
	public void testSortStringsBottomUp() {
		MergeSort<String> sorter = new MergeSort<>();
		String[] input = new String[]{"A", "D", "B", "Z", "L"};
		sorter.sort(input, false);
		Assert.assertThat(input, equalTo(new String[] {"A", "B", "D", "L", "Z"}));
	}

}
