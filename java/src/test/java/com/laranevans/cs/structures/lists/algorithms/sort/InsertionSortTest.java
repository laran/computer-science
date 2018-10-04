/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Insertion Sort")
public class InsertionSortTest extends BaseSortAlgorithmTest {

	@Test
	public void shouldSortAnIntegerListWithoutDuplicates() {
		sortAndVerify(
			new InsertionSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6},
			new Integer[]{2, 3, 5, 6, 7, 9});
	}

	@Test
	public void shouldSortAnArrayOfIntegersWithDuplicates() {
		sortAndVerify(
			new InsertionSort<>(),
			new Integer[]{2, 5, 3, 7, 9, 6, 3},
			new Integer[]{2, 3, 3, 5, 6, 7, 9});
	}
}
