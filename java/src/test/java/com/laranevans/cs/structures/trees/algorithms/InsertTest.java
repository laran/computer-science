/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("Insert")
public class InsertTest {

	@Test
	public void shouldInsertNodesInCorrectOrder() {
		BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(10);
		assertThat(Insert.insert(root, 15), is(equalTo(true)));
		assertThat(Insert.insert(root, 5), is(equalTo(true)));
		assertThat(Insert.insert(root, 19), is(equalTo(true)));
		assertThat(Insert.insert(root, 13), is(equalTo(true)));
		assertThat(Insert.insert(root, 7), is(equalTo(true)));
		assertThat(Insert.insert(root, 7), is(equalTo(false)));
		assertThat(Insert.insert(root, null), is(equalTo(false)));

		assertThat(root.getRight().getValue(), is(equalTo(15)));
		assertThat(root.getRight().getLeft().getValue(), is(equalTo(13)));
		assertThat(root.getRight().getRight().getValue(), is(equalTo(19)));
		assertThat(root.getLeft().getValue(), is(equalTo(5)));
		assertThat(root.getLeft().getRight().getValue(), is(equalTo(7)));
	}

}
