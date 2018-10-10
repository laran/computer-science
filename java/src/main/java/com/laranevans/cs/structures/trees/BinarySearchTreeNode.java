/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.Objects;

/**
 * A BinaryTreeNode with additional methods that are enabled by the ordering constraints
 * of a BinarySearchTree.
 *
 * @param &lt;V&gt;
 */
public class BinarySearchTreeNode<V extends Comparable> extends BinaryTreeNode<V> {
	public BinarySearchTreeNode(V value) {
		super(value);
	}

	/**
	 * Create a new node at the correct position in the tree under this node
	 * based on the value in the context of the binary search tree ordering
	 * constraints.
	 *
	 * @param value
	 * @return
	 */
	public BinarySearchTreeNode<V> add(V value) {
		if (Objects.isNull(value)) {
			return this;
		}

		BinarySearchTreeNode<V> node = this;
		while (!Objects.isNull(node)) {
			if (value.compareTo(node.getValue()) == 0) {
				return node; // value already exists
			} else if (value.compareTo(node.getValue()) < 0) {
				if (Objects.isNull(node.getLeft())) {
					node.setLeft(new BinarySearchTreeNode<>(value));
					break;
				} else {
					node = (BinarySearchTreeNode<V>) node.getLeft();
				}
			} else {
				if (Objects.isNull(node.getRight())) {
					node.setRight(new BinarySearchTreeNode<>(value));
					break;
				} else {
					node = (BinarySearchTreeNode<V>) node.getRight();
				}
			}
		}
		return this;
	}

}
