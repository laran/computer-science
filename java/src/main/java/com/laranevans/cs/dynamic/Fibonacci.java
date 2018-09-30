/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

/**
 * This is a dynamic programming problem.
 *
 * To determine how best to solve the problem, ask the question:
 *
 *   Do all sub-problems need to be solved?
 *
 * The answer, in this case is yes. So a bottom-up approach is
 * preferred for these reasons:
 *
 * - better use of memory because it can be initialized up-front
 * - no need for recursion, so less memory consumed by the call-stack.
 */
public class Fibonacci {

	public static long fib(int n) {

		// Create a cache for results
		// I chose Longs instead of Integers because the numbers can get big
		long[] cache = new long[n + 2];

		// Initialize the base cases of 0 and 1
		cache[0] = 0;
		cache[1] = 1;

		return fib(n, cache);
	}

	private static long fib(int n, long[] cache) {

		// because we have the cache with the base cases initialized,
		// we can take a bottom-up (tabulation) approach.
		for (int i = 2; i <= n; i++) {
			cache[i] = cache[i - 1] + cache[i - 2];
		}

		return cache[n];
	}
}
