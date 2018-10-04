/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Permute")
public class PermuteTest {

	@Test
	@DisplayName("should permute a String properly")
	public void shouldPermuteAString() {
		assertThat(new Permute().permute("abc"), Matchers.equalTo(
			Arrays.asList("abc", "acb", "bac", "bca", "cba", "cab")
		));
	}

	@Test
	public void shouldPermuteAnArrayOfObjects() {
		List<Object[]> output = new Permute().permute(new Object[]{'a', 'b', 'c'});
		assertThat(
			output,
			Matchers.equalTo(
				Arrays.asList(
					new Object[]{'a', 'b', 'c'},
					new Object[]{'a', 'c', 'b'},
					new Object[]{'b', 'a', 'c'},
					new Object[]{'b', 'c', 'a'},
					new Object[]{'c', 'b', 'a'},
					new Object[]{'c', 'a', 'b'})
			));
	}
}
