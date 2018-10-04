/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.greedy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Fisher-Yates Shuffle")
public class FisherYatesShuffleTest {

	@Test
	public void shouldRetainAllElementsInResult() {
		Integer[] a = new Integer[]{1, 2, 3, 4, 5};
		Integer[] check = new Integer[a.length];
		System.arraycopy(a, 0, check, 0, a.length);
		new FisherYatesShuffle().shuffle(a);
		assertThat(a, not(equalTo(check)));
		assertThat(Arrays.asList(check), containsInAnyOrder(a));
	}

}
