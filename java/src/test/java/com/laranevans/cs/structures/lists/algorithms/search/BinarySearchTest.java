/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.search;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testEvenNumber() {
		Integer[] a = new Integer[] {1, 2, 3, 4, 5, 6};
		Assert.assertThat(new BinarySearch<Integer>().search(a, 4), Matchers.equalTo(3));
	}

	@Test
	public void testOddNumber() {
		Integer[] a = new Integer[] {1, 2, 3, 4, 5};
		Assert.assertThat(new BinarySearch<Integer>().search(a, 4), Matchers.equalTo(3));
	}

	@Test
	public void testFindLastElement() {
		Integer[] a = new Integer[] {1, 2, 3, 4, 5};
		Assert.assertThat(new BinarySearch<Integer>().search(a, 5), Matchers.equalTo(4));
	}

	@Test
	public void testFindFirstElement() {
		Integer[] a = new Integer[] {1, 2, 3, 4, 5};
		Assert.assertThat(new BinarySearch<Integer>().search(a, 1), Matchers.equalTo(0));
	}

	@Test
	public void testEmptyArray() {
		Integer[] a = new Integer[] {};
		Assert.assertThat(new BinarySearch<Integer>().search(a, 4), Matchers.equalTo(-1));
	}
}
