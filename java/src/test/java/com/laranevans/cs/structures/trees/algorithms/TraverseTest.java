/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@DisplayName("Traverse")
public class TraverseTest {

	BinarySearchTreeNode<Integer> rightRotated;
	BinarySearchTreeNode<Integer> leftRotated;

	@BeforeEach
	public void setup() {
		rightRotated = new BinarySearchTreeNode<>(10);
		Arrays.stream(new int[] {5, 15, 13, 18}).forEach(i -> rightRotated.add(i));

		leftRotated = new BinarySearchTreeNode<>(15);
		Arrays.stream(new int[] {10, 18, 5, 13}).forEach(i -> leftRotated.add(i));
	}

	@Test
	public void shouldProperlyTraversePreOrder() {
		final List results = new ArrayList();
		Traverse.preOrder(rightRotated, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(10, 5, 15, 13, 18))));

		// ensure that null values are handled properly
		assertThat(Traverse.preOrder(null, node -> {return false;}), is(nullValue()));
	}

	@Test
	public void shouldProperlyTraverseInOrder() {
		final List results = new ArrayList();
		Traverse.inOrder(rightRotated, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(5, 10, 13, 15, 18))));

		// ensure that null values are handled properly
		assertThat(Traverse.inOrder(null, node -> {return false;}), is(nullValue()));
	}

	@Test
	public void shouldProperlyTraversePostOrder() {
		final List results = new ArrayList();
		Traverse.postOrder(rightRotated, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(5, 13, 18, 15, 10))));

		// ensure that null values are handled properly
		assertThat(Traverse.postOrder(null, node -> {return false;}), is(nullValue()));
	}

	@Test
	public void shouldProperlyTraverseLevelOrder() {
		final List results = new ArrayList();
		Traverse.levelOrder(rightRotated, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(10, 5, 15, 13, 18))));

		// ensure that null values are handled properly
		assertThat(Traverse.levelOrder(null, node -> {return false;}), is(nullValue()));
	}

}
