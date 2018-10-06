/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.dynamic;

import java.util.Stack;

/**
 * Towers of Hanoi
 */
public class Hanoi {

	private int numDiscs;
	private int iFromTower;
	private StackOfIntegers[] towers;
	private boolean isInitialized;
	private int moveCounter;

	public Hanoi() {
		isInitialized = false;
	}

	// Main method is here just to demonstrate how to use it.
	// Not important to parse parameters from command line arguments right now. So I left that out.
	public static void main(String[] args) {
		// Initialize and solve the puzzle and show all work
		Hanoi hanoi = new Hanoi();
		hanoi.solve(5, 0, 2);

		// To hide all work, use the optional 4th parameter to solve
		// hanoi.solve(5, 0, 2, false)
	}

	public void solve(int numDiscs, int iFromTower, int iToTower) {
		solve(numDiscs, iFromTower, iToTower, true);
	}

	public void solve(int numDiscs, int iFromTower, int iToTower, boolean showWork) {
		initialize(numDiscs, iFromTower, showWork);
		checkAndDoSolve(iToTower, showWork);
	}

	private void initialize(int numDiscs, int iFromTower, boolean showWork) {
		this.numDiscs = numDiscs;
		this.iFromTower = iFromTower;
		this.towers = new StackOfIntegers[]{
			new StackOfIntegers(),
			new StackOfIntegers(),
			new StackOfIntegers()
		};

		for (int i = numDiscs; i > 0; i--) {
			towers[iFromTower].push(i);
		}

		if (showWork) {
			this.showTowers("Move #0: Initial state");
		}
		this.isInitialized = true;
	}

	private void checkAndDoSolve(int iToTower, boolean showWork) {
		if (!this.isInitialized) {
			throw new RuntimeException("Please call initialize(int, int) before solving");
		}

		this.moveCounter = 0;
		this.doSolve(this.numDiscs, this.iFromTower, iToTower, showWork);
		this.isInitialized = false;
	}

	// This is the actual algorithm.
	private void doSolve(int _numDiscs, int _iFromTower, int _iToTower, boolean showWork) {
		if (_numDiscs == 0) {
			// do nothing
		} else if (_numDiscs == 1) {
			moveDisc(_iFromTower, _iToTower, showWork);
		} else {
			int _iAuxTower = getAuxTowerIndex(_iFromTower, _iToTower);
			doSolve(_numDiscs - 1, _iFromTower, _iAuxTower, showWork);
			moveDisc(_iFromTower, _iToTower, showWork);
			doSolve(_numDiscs - 1, _iAuxTower, _iToTower, showWork);
		}
	}

	// Determine which tower is the auxiliary tower.
	// Method is protected just to expose it enough to make it testable.
	protected int getAuxTowerIndex(int fromTower, int toTower) {
		return 3 - fromTower - toTower;
	}

	// Move a disc from one tower to another
	private void moveDisc(int iFrom, int iTo, boolean showWork) {
		moveCounter++;
		int value = this.towers[iFrom].pop();
		this.towers[iTo].push(value);
		if (showWork) {
			this.showTowers(String.format(
				"Move #%s: Move value=%s from Tower=%s to Tower=%s", moveCounter, value, iFrom, iTo));
		}
	}

	// Print the towers in a standard format
	private void showTowers(String message) {
		System.out.println(message);
		for (int y = this.numDiscs - 1; y >= 0; y--) {
			System.out.println(String.format("%s\t%s\t%s",
				towerElement(0, y),
				towerElement(1, y),
				towerElement(2, y)
			));
		}
		System.out.println("-\t-\t-");
	}

	// Get the element in a given tower at y depth
	private String towerElement(int iTower, int y) {
		if (y >= towers[iTower].size()) {
			return " ";
		}
		return "" + towers[iTower].elementAt(y);
	}

	// Just some syntactic sugar to get the compiler to allow me to create an array of Stacks of Integers
	private static class StackOfIntegers extends Stack<Integer> {
	}
}
