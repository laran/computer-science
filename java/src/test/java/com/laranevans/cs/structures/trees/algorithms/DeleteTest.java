/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import com.laranevans.cs.structures.trees.TreePrinter;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Delete")
public class DeleteTest {

	private BinarySearchTreeNode<Integer> root;

	@BeforeEach
	public void setup() {
		root = new BinarySearchTreeNode<>(10);
		Arrays.asList(15, 5, 19, 13, 7).stream().forEach(i -> {
			Insert.insert(root, i);
		});

		System.out.println("Before:");
		System.out.println("------");
		TreePrinter.print(root);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("After:");
		System.out.println("------");
		TreePrinter.print(root);
	}

	@Test
	public void shouldDeleteValueAtRootNodeWithMinWithNoRightChild() {
		Delete.delete(root, root.getValue());
		assertThat(root.getValue(), is(equalTo(13)));
		assertThat(root.getLeft().getValue(), is(equalTo(5)));
		assertThat(root.getRight().getValue(), is(equalTo(15)));
		assertThat(root.getRight().getLeft(), is(nullValue()));
		assertThat(root.getRight().getRight().getValue(), is(equalTo(19)));
	}

	@Test
	public void shouldDeleteValueAtRootNodeWithMinWithRightChild() {
		Insert.insert(root, 14);
		System.out.println("Altered Tree:");
		TreePrinter.print(root);
		Delete.delete(root, root.getValue());
		assertThat(root.getValue(), is(equalTo(13)));
		assertThat(root.getLeft().getValue(), is(equalTo(5)));
		assertThat(root.getRight().getValue(), is(equalTo(15)));
		assertThat(root.getRight().getLeft().getValue(), is(equalTo(14)));
		assertThat(root.getRight().getLeft().getLeft(), is(nullValue()));
		assertThat(root.getRight().getLeft().getRight(), is(nullValue()));
		assertThat(root.getRight().getRight().getValue(), is(equalTo(19)));
	}

	@Test
	public void shouldDeleteMaxValueWithZeroChildren() {
		Integer max = MaxValue.maxValue(root).getValue();
		assertThat(max, is(equalTo(19)));
		Delete.delete(root, max);
		assertThat(Search.search(root, max), is(nullValue()));
	}

	@Test
	public void shouldDeleteMinValueWithZeroChildren() {
		Integer min = MinValue.minValue(root).getValue();
		assertThat(min, is(equalTo(5)));
		Delete.delete(root, min);
		assertThat(Search.search(root, min), is(nullValue()));
		assertThat(root.getValue(), is(equalTo(10)));
		assertThat(root.getLeft(), is(notNullValue()));
		assertThat(root.getLeft().getValue(), is(equalTo(7)));
		assertThat(root.getLeft().getLeft(), is(nullValue()));
		assertThat(root.getLeft().getRight(), is(nullValue()));
	}

	@Test
	public void shouldDeleteNodesWithTwoLeafChildren() {
		Delete.delete(root, 15);
		assertThat(Search.search(root, 15), is(nullValue()));

		final List<Comparable> results = new ArrayList();
		Traverse.levelOrder(root, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(10, 5, 19, 7, 13))));
	}

	@Test
	public void shouldDeleteNodesWithTwoChildrenWithChildren() {
		Insert.insert(root, 11);
		Delete.delete(root, 15);
		assertThat(Search.search(root, 15), is(nullValue()));

		final List<Comparable> results = new ArrayList();
		Traverse.levelOrder(root, node -> {
			// System.out.println(node.getValue());
			results.add(node.getValue());
			return false;
		});
		assertThat(results, is(equalTo(Arrays.asList(10, 5, 19, 7, 13, 11))));
	}

}
