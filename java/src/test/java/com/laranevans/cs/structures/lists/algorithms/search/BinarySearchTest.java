/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Binary Search")
public class BinarySearchTest {

	@Test
	public void testEvenNumber() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6};
		assertThat(new BinarySearch<Integer>().search(a, 4), equalTo(3));
	}

	@Test
	public void testOddNumber() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};
		assertThat(new BinarySearch<Integer>().search(a, 4), equalTo(3));
	}

	@Test
	public void testFindLastElement() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};
		assertThat(new BinarySearch<Integer>().search(a, 5), equalTo(4));
	}

	@Test
	public void testFindFirstElement() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};
		assertThat(new BinarySearch<Integer>().search(a, 1), equalTo(0));
	}

	@Test
	public void testEmptyArray() {
		Integer[] a = new Integer[]{};
		assertThat(new BinarySearch<Integer>().search(a, 4), equalTo(-1));
	}
}
