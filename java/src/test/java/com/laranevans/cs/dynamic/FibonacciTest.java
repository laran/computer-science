/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Fibonacci")
public class FibonacciTest {

	@Test
	public void shouldProduceTheCorrectResult() {
		assertThat(Fibonacci.fib(0), equalTo(0L));
		assertThat(Fibonacci.fib(1), equalTo(1L));
		assertThat(Fibonacci.fib(2), equalTo(1L));
		assertThat(Fibonacci.fib(3), equalTo(2L));
		assertThat(Fibonacci.fib(4), equalTo(3L));
		assertThat(Fibonacci.fib(5), equalTo(5L));
	}
}
