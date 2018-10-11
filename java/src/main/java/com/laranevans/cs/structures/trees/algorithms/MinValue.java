/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

public class MinValue {

	public static <V extends Comparable> BinarySearchTreeNode<V> minValue(BinarySearchTreeNode<V> root) {
		if (root == null) {
			return null;
		}

		BinarySearchTreeNode<V> node = root;
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

}
