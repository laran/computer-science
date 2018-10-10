/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Binary Search Tree")
public class BinarySearchTreeNodeTest {

	BinarySearchTreeNode<Integer> rightRotated;
	BinarySearchTreeNode<Integer> leftRotated;

	@BeforeEach
	public void setup() {
		rightRotated = new BinarySearchTreeNode<>(10);
		Arrays.stream(new int[]{5, 15, 13, 18}).forEach(i -> rightRotated.add(i));

		leftRotated = new BinarySearchTreeNode<>(15);
		Arrays.stream(new int[]{10, 18, 5, 13}).forEach(i -> leftRotated.add(i));
	}

	@Test
	public void shouldFindValueAtRoot() {
		BinarySearchTreeNode ten = rightRotated.find(10);
		assertThat(ten.getLeft().getValue(), is(equalTo(5)));
		assertThat(ten.getRight().getValue(), is(equalTo(15)));
	}

	@Test
	public void shouldFindValueInLeftSubtree() {
		BinarySearchTreeNode ten = leftRotated.find(5);
		assertThat(ten.getValue(), is(equalTo(5)));
		assertThat(ten.getLeft(), is(nullValue()));
		assertThat(ten.getRight(), is(nullValue()));
	}

	@Test
	public void shouldFindValueInRightSubtree() {
		BinarySearchTreeNode thirteen = rightRotated.find(13);
		assertThat(thirteen.getValue(), is(equalTo(13)));
		assertThat(thirteen.getLeft(), is(nullValue()));
		assertThat(thirteen.getRight(), is(nullValue()));
	}

	@Test
	public void shouldNotFindAValueNotInTheTree() {
		assertThat(rightRotated.find(45), is(nullValue()));
	}

	@Test
	public void shouldHandleTryingToFindANullValue() {
		assertThat(rightRotated.find(null), is(nullValue()));
	}

}
