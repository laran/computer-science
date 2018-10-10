/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@DisplayName("Search")
public class SearchTest {

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
		BinarySearchTreeNode ten = Search.toFind(rightRotated, 10);
		assertThat(ten.getLeft().getValue(), is(equalTo(5)));
		assertThat(ten.getRight().getValue(), is(equalTo(15)));
	}

	@Test
	public void shouldFindValueInLeftSubtree() {
		BinarySearchTreeNode ten = Search.toFind(leftRotated, 5);
		assertThat(ten.getValue(), is(equalTo(5)));
		assertThat(ten.getLeft(), is(nullValue()));
		assertThat(ten.getRight(), is(nullValue()));
	}

	@Test
	public void shouldFindValueInRightSubtree() {
		BinarySearchTreeNode thirteen = Search.toFind(rightRotated, 13);
		assertThat(thirteen.getValue(), is(equalTo(13)));
		assertThat(thirteen.getLeft(), is(nullValue()));
		assertThat(thirteen.getRight(), is(nullValue()));
	}

	@Test
	public void shouldNotFindAValueNotInTheTree() {
		assertThat(Search.toFind(rightRotated, 45), is(nullValue()));
	}

	@Test
	public void shouldThrowAnIllegalArgumentExceptionWhenTryingToFindANullValue() {
		// searching for a null value should throw an exception because null values
		// cannot be safely compared to other values
		Assertions.assertThrows(
			IllegalArgumentException.class, () -> Search.toFind(rightRotated, null));

		// searching on a null root should throw an exception
		Assertions.assertThrows(
			IllegalArgumentException.class, () -> Search.toFind(null, null));
	}

}
