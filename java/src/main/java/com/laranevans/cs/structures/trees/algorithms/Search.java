/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

import java.util.Comparator;
import java.util.Objects;

/**
 * Search a BinarySearchTreeNode for a given value.
 */
public class Search {

	/**
	 * Search using natural ordering.
	 *
	 * @param root
	 * @param value
	 * @param &lt;V&gt;
	 * @return
	 */
	public static <V extends Comparable> BinarySearchTreeNode<V> toFind(BinarySearchTreeNode<V> root, V value) {
		return toFind(root, value, Comparator.naturalOrder());
	}

	/**
	 * Find a node with the given value (if it exists).
	 *
	 * @param root
	 * @param value
	 * @param comparator
	 * @param &lt;V&gt;
	 * @return
	 */
	public static <V extends Comparable> BinarySearchTreeNode<V> toFind(
		BinarySearchTreeNode<V> root, V value, Comparator<V> comparator) {
		if (Objects.isNull(root)) {
			throw new IllegalArgumentException("Unable to search from a null root");
		}
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("Unable to compare null values");
		}

		BinarySearchTreeNode<V> node = root;
		while (!Objects.isNull(node)) {
			int comparison = comparator.compare(value, node.getValue());
			if (comparison == 0) {
				return node;
			} else if (comparison > 0) {
				node = (BinarySearchTreeNode<V>) node.getRight();
			} else {
				node = (BinarySearchTreeNode<V>) node.getLeft();
			}
		}
		return node;
	}

}
