/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.greedy;

import com.laranevans.cs.structures.lists.algorithms.greedy.FisherYatesShuffle;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;

public class FisherYatesShuffleTest {

	@Test
	public void ensureThatAllElementsInResult() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};
		Integer[] check = new Integer[a.length];
		System.arraycopy(a, 0, check, 0, a.length);
		new FisherYatesShuffle().shuffle(a);
		Assert.assertThat(a, not(equalTo(check)));
		Assert.assertThat(Arrays.asList(check), containsInAnyOrder(a));
	}

}
