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
	private BinaryTreeNode parent;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

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

		BinaryTreeNode x = this;
		BinaryTreeNode y = this.right;
		this.right = y.left;
		if (!Objects.isNull(y.left)) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (!Objects.isNull(x.parent)) {
			if (this == this.parent.left) {
				x.parent.left = y;
			} else if (!Objects.isNull(x.parent)) {
				x.parent.right = y;
			}
		}
		y.left = x;
		x.parent = y;
		return y;
	}

	/**
	 *
	 * @return the node that rotated into the same position
	 */
	public BinaryTreeNode rotateRight() {
		if (Objects.isNull(this.left)) {
			return this;
		}

		BinaryTreeNode y = this;
		BinaryTreeNode x = this.left;
		y.left = x.right;
		if (!Objects.isNull(x.getRight())) {
			x.right.parent = y;
		}
		x.parent = y.parent;
		if (!Objects.isNull(y.parent)) {
			if (this == this.parent.right) {
				y.parent.right = x;
			} else if (!Objects.isNull(y.parent)) {
				y.parent.left = x;
			}
		}
		x.right = y;
		y.parent = x;

		return x;
	}
}
