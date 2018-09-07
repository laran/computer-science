/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.algorithms.sort;

import org.hamcrest.Matchers;
import org.junit.Assert;

public class BaseSortAlgorithmTest {

	protected <V extends Comparable> void sortAndVerify(BaseSortAlgorithm<V> algorithm, V[] a, V[] expected) {
		algorithm.sort(a);
		Assert.assertThat(a, Matchers.equalTo(expected));
	}

}
