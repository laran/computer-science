/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

public class Insert {

	/**
	 * Create a new node at the correct position in the tree under this node
	 * based on the value in the context of the binary search tree ordering
	 * constraints.
	 *
	 * @param root  the root node under which to add the value
	 * @param value
	 * @return
	 */
	public static <V extends Comparable> boolean insert(BinarySearchTreeNode<V> root, V value) {
		if (value == null) {
			return false;
		}

		BinarySearchTreeNode<V> node = root;
		while (node != null) {
			if (value.compareTo(node.getValue()) == 0) {
				return false; // value already exists
			} else if (value.compareTo(node.getValue()) < 0) {
				if (node.getLeft() == null) {
					node.setLeft(new BinarySearchTreeNode<>(value));
					return true;
				} else {
					node = (BinarySearchTreeNode<V>) node.getLeft();
				}
			} else {
				if (node.getRight() == null) {
					node.setRight(new BinarySearchTreeNode<>(value));
					return true;
				} else {
					node = (BinarySearchTreeNode<V>) node.getRight();
				}
			}
		}
		return false;
	}

}
