/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.sort;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BaseSortAlgorithmTest {

	protected <V extends Comparable> void sortAndVerify(BaseSortAlgorithm<V> algorithm, V[] a, V[] expected) {
		algorithm.sort(a);
		assertThat(a, equalTo(expected));
	}

}
