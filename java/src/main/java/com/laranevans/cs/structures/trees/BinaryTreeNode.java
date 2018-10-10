/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.Objects;

/**
 * A basic TreeNode for use in a BinaryTree.
 *
 * @param &lt;V&gt;
 */
public class BinaryTreeNode<V extends Comparable> {
	private V value;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	// Keep track of the parent makes rotation more straightforward
	private BinaryTreeNode parent;

	public BinaryTreeNode(V value) {
		this(value, null, null);
	}

	public BinaryTreeNode(V value, BinaryTreeNode left, BinaryTreeNode right) {
		this.value = value;
		setLeft(left);
		setRight(right);
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
		if (!Objects.isNull(left)) {
			left.parent = this;
		}
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
		if (!Objects.isNull(right)) {
			right.parent = this;
		}
	}

	/**
	 *
	 * @return the node that rotated into the same position
	 */
	public BinaryTreeNode rotateLeft() {
		if (Objects.isNull(this.right)) {
			return this;
		}

		BinaryTreeNode oldRoot = this;
		BinaryTreeNode newRoot = this.right;
		this.right = newRoot.left;
		if (!Objects.isNull(newRoot.left)) {
			newRoot.left.parent = oldRoot;
		}
		newRoot.parent = oldRoot.parent;
		if (!Objects.isNull(oldRoot.parent)) {
			if (this == this.parent.left) {
				oldRoot.parent.left = newRoot;
			} else {
				oldRoot.parent.right = newRoot;
			}
		}
		newRoot.left = oldRoot;
		oldRoot.parent = newRoot;
		return newRoot;
	}

	/**
	 *
	 * @return the node that rotated into the same position
	 */
	public BinaryTreeNode rotateRight() {
		if (Objects.isNull(this.left)) {
			return this;
		}

		BinaryTreeNode oldRoot = this;
		BinaryTreeNode newRoot = this.left;
		oldRoot.left = newRoot.right;
		if (!Objects.isNull(newRoot.getRight())) {
			newRoot.right.parent = oldRoot;
		}
		newRoot.parent = oldRoot.parent;
		if (!Objects.isNull(oldRoot.parent)) {
			if (this == this.parent.right) {
				oldRoot.parent.right = newRoot;
			} else {
				oldRoot.parent.left = newRoot;
			}
		}
		newRoot.right = oldRoot;
		oldRoot.parent = newRoot;

		return newRoot;
	}
}
