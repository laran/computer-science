/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.junit.Test;

public class SelectionSortTest extends BaseSortAlgorithmTest {

	@Test
	public void testSortIntegersWithNoDuplicates() {
		sortAndVerify(
			new SelectionSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6},
			new Integer[]{2, 3, 5, 6, 7, 9});
	}

	@Test
	public void testSortIntegersWithDuplicates() {
		sortAndVerify(
			new SelectionSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6, 3},
			new Integer[]{2, 3, 3, 5, 6, 7, 9});
	}

}
