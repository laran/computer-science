/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	public void shouldFind14With100FloorsAnd2Eggs() {
		// Can only do this with DP. Too slow otherwise.
		assertThat(EggDropSolver.solveWithDP(100, 2), is(equalTo(14)));
	}

	@Test
	public void shouldFind9With100FloorsAnd3Eggs() {
		// Can only do this with DP. Too slow otherwise.
		assertThat(EggDropSolver.solveWithDP(100, 3), is(equalTo(9)));
	}

	@Test
	public void shouldFind8With100FloorsAnd4Eggs() {
		// Can only do this with DP. Too slow otherwise.
		assertThat(EggDropSolver.solveWithDP(100, 4), is(equalTo(8)));
	}

}
