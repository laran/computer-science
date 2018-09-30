/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFib() {
		Assert.assertThat(Fibonacci.fib(0), Matchers.equalTo(0L));
		Assert.assertThat(Fibonacci.fib(1), Matchers.equalTo(1L));
		Assert.assertThat(Fibonacci.fib(2), Matchers.equalTo(1L));
		Assert.assertThat(Fibonacci.fib(3), Matchers.equalTo(2L));
		Assert.assertThat(Fibonacci.fib(4), Matchers.equalTo(3L));
		Assert.assertThat(Fibonacci.fib(5), Matchers.equalTo(5L));
	}
}
