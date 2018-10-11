/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import com.laranevans.cs.structures.trees.BinaryTreeNode;

public class MaxValue {

	public static <V extends Comparable> BinarySearchTreeNode<V> maximumValue(BinarySearchTreeNode<V> root) {
		if (root == null) {
			return null;
		}

		BinaryTreeNode node = root;
		while(node.getRight() != null) {
			node = node.getRight();
		}
		return (BinarySearchTreeNode<V>) node;
	}

}
