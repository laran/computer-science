/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Max Value")
public class MaxValueTest {

	@Test
	public void shouldFindMaximumValueAtLeaf() {
		BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(10);
		Insert.insert(root, 15);
		Insert.insert(root, 25);
		Insert.insert(root, 28);

		BinarySearchTreeNode<Integer> node = MaxValue.maximumValue(root);
		assertThat(node, is(notNullValue()));
		assertThat(node.getValue(), is(equalTo(28)));
	}

	@Test
	public void shouldFindMaximumValueAtRoot() {
		BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(15);
		Insert.insert(root, 10);
		Insert.insert(root, 5);
		Insert.insert(root, 2);

		BinarySearchTreeNode<Integer> node = MaxValue.maximumValue(root);
		assertThat(node, is(notNullValue()));
		assertThat(node.getValue(), is(equalTo(15)));
	}

}
