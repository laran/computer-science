/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.algorithms.strings;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PermuteTest {

	@Test
	public void permuteStrings() {
		Assert.assertThat(new Permute().permute("abc"), Matchers.equalTo(
			Arrays.asList("abc", "acb", "bac", "bca", "cba", "cab")
		));
	}

}
