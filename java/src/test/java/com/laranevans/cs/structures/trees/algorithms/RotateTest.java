/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("Rotate")
public class RotateTest {

	// Using BinarySearchTreeNodes because I can add() to them. Just easier.
	BinarySearchTreeNode<Integer> rightRotated;
	BinarySearchTreeNode<Integer> leftRotated;

	@BeforeEach
	public void setup() {
		rightRotated = new BinarySearchTreeNode<>(10);
		Arrays.stream(new int[] {5, 15, 13, 18}).forEach(i -> Insert.insert(rightRotated, i));

		leftRotated = new BinarySearchTreeNode<>(15);
		Arrays.stream(new int[] {10, 18, 5, 13}).forEach(i -> Insert.insert(leftRotated, i));
	}

	private void validateRightRotated(BinarySearchTreeNode root) {
		assertThat(root.getValue(), is(equalTo(10)));
		assertThat(root.getLeft().getValue(), is(equalTo(5)));
		assertThat(root.getRight().getValue(), is(equalTo(15)));
		assertThat(root.getRight().getLeft().getValue(), is(equalTo(13)));
		assertThat(root.getRight().getRight().getValue(), is(equalTo(18)));
	}

	private void validateLeftRotated(BinarySearchTreeNode root) {
		assertThat(root.getValue(), is(equalTo(15)));
		assertThat(root.getLeft().getValue(), is(equalTo(10)));
		assertThat(root.getRight().getValue(), is(equalTo(18)));
		assertThat(root.getLeft().getLeft().getValue(), is(equalTo(5)));
		assertThat(root.getLeft().getRight().getValue(), is(equalTo(13)));
	}

	@Test
	public void shouldProperlyRotateLeft() {
		validateRightRotated(rightRotated);
		validateLeftRotated((BinarySearchTreeNode) Rotate.left(rightRotated));
	}

	@Test
	public void shouldProperlyRotateRight() {
		validateLeftRotated(leftRotated);
		validateRightRotated((BinarySearchTreeNode) Rotate.right(leftRotated));
	}

}
