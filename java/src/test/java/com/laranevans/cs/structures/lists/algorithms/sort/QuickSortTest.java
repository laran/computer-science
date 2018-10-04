/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Quick Sort")
public class QuickSortTest extends BaseSortAlgorithmTest {

	@Test
	public void shouldSortAnArrayOfIntegersWithoutDuplicates() {
		sortAndVerify(
			new QuickSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6},
			new Integer[]{2, 3, 5, 6, 7, 9});
	}

	@Test
	public void shouldSortAnArrayOfIntegersWithDuplicates() {
		sortAndVerify(
			new QuickSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6, 3},
			new Integer[]{2, 3, 3, 5, 6, 7, 9});
	}
}