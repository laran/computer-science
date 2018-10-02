/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import org.junit.Test;

public class MergeSortBottomUpTest extends BaseSortAlgorithmTest {

	@Test
	public void testSortIntegersBottomUp() {
		sortAndVerify(
			new MergeSortBottomUp<>(),
			new Integer[]{3, 5, 1, 2, 4},
			new Integer[]{1, 2, 3, 4, 5});
	}

	@Test
	public void testSortStringsBottomUp() {
		sortAndVerify(
			new MergeSortBottomUp<>(),
			new String[]{"A", "D", "B", "Z", "L"},
			new String[]{"A", "B", "D", "L", "Z"});
	}

}
