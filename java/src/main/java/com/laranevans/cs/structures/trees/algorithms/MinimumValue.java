/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import com.laranevans.cs.structures.trees.BinaryTreeNode;

public class MinimumValue {

	public static <V extends Comparable> BinarySearchTreeNode<V> minimumValue(BinarySearchTreeNode<V> root) {
		if (root == null) {
			return null;
		}

		BinaryTreeNode node = root;
		while(node.getLeft() != null) {
			node = node.getLeft();
		}
		return (BinarySearchTreeNode<V>) node;
	}

}
