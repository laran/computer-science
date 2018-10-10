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
	protected BinaryTreeNode<V> left;
	protected BinaryTreeNode<V> right;
	// Keep track of the parent to make rotation more straightforward
	protected BinaryTreeNode<V> parent;

	public BinaryTreeNode(V value) {
		this(value, null, null);
	}

	public BinaryTreeNode(V value, BinaryTreeNode<V> left, BinaryTreeNode<V> right) {
		setValue(value);
		setLeft(left);
		setRight(right);
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		// Disallow null values because they cannot be compared.
		if (value == null) {
			throw new IllegalArgumentException("Null values are not allowed");
		}
		this.value = value;
	}

	public BinaryTreeNode<V> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<V> left) {
		setLeft(left, true);
	}

	// It's handy to not automatically set the parent during rotation
	public void setLeft(BinaryTreeNode<V> left, boolean setParent) {
		this.left = left;
		if (!Objects.isNull(left) && setParent) {
			left.parent = this;
		}
	}

	public BinaryTreeNode<V> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<V> right) {
		setRight(right, true);
	}

	// It's handy to not automatically set the parent during rotation
	public void setRight(BinaryTreeNode<V> right, boolean setParent) {
		this.right = right;
		if (!Objects.isNull(right) && setParent) {
			right.parent = this;
		}
	}

	public BinaryTreeNode<V> getParent() {
		return parent;
	}

	public void setParent(BinaryTreeNode<V> parent) {
		this.parent = parent;
	}

}
