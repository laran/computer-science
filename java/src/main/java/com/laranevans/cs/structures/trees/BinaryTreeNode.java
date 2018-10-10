/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.Objects;

/**
 * A basic TreeNode for use in a BinaryTree.
 *
 * @param &lt;V&gt;
 */
public class BinaryTreeNode<V extends Comparable> {
	protected V value;
	protected BinaryTreeNode left;
	protected BinaryTreeNode right;
	// Keep track of the parent makes rotation more straightforward
	protected BinaryTreeNode parent;

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
		setLeft(left, true);
	}

	public void setLeft(BinaryTreeNode left, boolean setParent) {
		this.left = left;
		if (!Objects.isNull(left) && setParent) {
			left.parent = this;
		}
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		setRight(right, true);
	}

	public void setRight(BinaryTreeNode right, boolean setParent) {
		this.right = right;
		if (!Objects.isNull(right) && setParent) {
			right.parent = this;
		}
	}

	public BinaryTreeNode getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode parent) {
		this.parent = parent;
	}

}
