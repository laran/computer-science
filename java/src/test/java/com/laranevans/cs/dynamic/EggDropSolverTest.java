/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("EggDropSolver")
public class EggDropSolverTest {

	// I used a table on this page to lookup the known results:
	// http://datagenetics.com/blog/july22012/index.html

	@Test
	public void shouldWorkRecursivelyOnSmallerProblems() {
		assertThat(EggDropSolver.solveRecursively(6, 2), is(equalTo(3)));
		assertThat(EggDropSolver.solveRecursively(7, 2), is(equalTo(4)));
		assertThat(EggDropSolver.solveRecursively(7, 3), is(equalTo(3)));
		assertThat(EggDropSolver.solveRecursively(8, 3), is(equalTo(4)));
	}

	@Test
	public void shouldFind14With100FloorsAnd2EggsUsingDP() {
		solveWithDPAndCheck(100, 2, 14);
	}

	@Test
	public void shouldFind9With100FloorsAnd3EggsUsingDP() {
		solveWithDPAndCheck(100, 3, 9);
	}

	@Test
	public void shouldFind8With100FloorsAnd4EggsUsingDP() {
		solveWithDPAndCheck(100, 4, 8);
	}

	private void solveWithDPAndCheck(int n, int k, int expectedResult) {
		int[][] memo = EggDropSolver.solveWithDP(n, k);
		show(memo);
		assertThat(memo[n][k], is(equalTo(expectedResult)));
	}

	private void show(int[][] memo) {
		for (int i = 0; i < memo.length; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
	}
}
