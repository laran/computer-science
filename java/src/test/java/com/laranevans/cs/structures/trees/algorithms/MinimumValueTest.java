/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("Minimum Value")
public class MinimumValueTest {

	@Test
	public void shouldFindMinimumValueAtLeaf() {
		BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(10);
		Insert.insert(root, 15);
		Insert.insert(root, 5);
		Insert.insert(root, 2);

		BinarySearchTreeNode<Integer> node = MinimumValue.minimumValue(root);
		assertThat(node, is(notNullValue()));
		assertThat(node.getValue(), is(equalTo(2)));
	}

	@Test
	public void shouldFindMinimumValueAtRoot() {
		BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(10);
		Insert.insert(root, 15);
		Insert.insert(root, 25);
		Insert.insert(root, 22);

		BinarySearchTreeNode<Integer> node = MinimumValue.minimumValue(root);
		assertThat(node, is(notNullValue()));
		assertThat(node.getValue(), is(equalTo(10)));
	}

}
