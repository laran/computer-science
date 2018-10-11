/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

public class MaxValue {

	public static <V extends Comparable> BinarySearchTreeNode<V> maxValue(BinarySearchTreeNode<V> root) {
		if (root == null) {
			return null;
		}

		BinarySearchTreeNode<V> node = root;
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}

}
