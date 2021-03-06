/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms;

import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Permute")
public class PermuteTest {

	@Test
	public void shouldPermuteAString() {
		assertThat(new Permute().permute("abc"), equalTo(
			Arrays.asList("abc", "acb", "bac", "bca", "cba", "cab")
		));
	}

	@Test
	public void shouldPermuteAnArrayOfObjects() {
		List<Object[]> output = new Permute().permute(new Object[]{'a', 'b', 'c'});
		assertThat(output.get(0), is(arrayContaining('a', 'b', 'c')));
		assertThat(output.get(1), is(arrayContaining('a', 'c', 'b')));
		assertThat(output.get(2), is(arrayContaining('b', 'a', 'c')));
		assertThat(output.get(3), is(arrayContaining('b', 'c', 'a')));
		assertThat(output.get(4), is(arrayContaining('c', 'b', 'a')));
		assertThat(output.get(5), is(arrayContaining('c', 'a', 'b')));
	}
}
