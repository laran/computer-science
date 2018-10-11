/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

/**
 * A BinaryTreeNode with additional methods that are enabled by the ordering constraints
 * of a BinarySearchTree.
 *
 * @param &lt;V&gt;
 */
public class BinarySearchTreeNode<V extends Comparable> {
	protected V value;
	protected BinarySearchTreeNode<V> left;
	protected BinarySearchTreeNode<V> right;
	// Keep track of the parent to make rotation more straightforward
	protected BinarySearchTreeNode<V> parent;

	public BinarySearchTreeNode(V value) {
		this(value, null, null);
	}

	public BinarySearchTreeNode(V value, BinarySearchTreeNode<V> left, BinarySearchTreeNode<V> right) {
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

	public BinarySearchTreeNode<V> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode<V> left) {
		setLeft(left, true);
	}

	// It's handy to not automatically set the parent during rotation
	public void setLeft(BinarySearchTreeNode<V> left, boolean setParent) {
		this.left = left;
		if (left != null && setParent) {
			left.parent = this;
		}
	}

	public BinarySearchTreeNode<V> getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode<V> right) {
		setRight(right, true);
	}

	// It's handy to not automatically set the parent during rotation
	public void setRight(BinarySearchTreeNode<V> right, boolean setParent) {
		this.right = right;
		if (right != null && setParent) {
			right.parent = this;
		}
	}

	public BinarySearchTreeNode<V> getParent() {
		return parent;
	}

	public void setParent(BinarySearchTreeNode<V> parent) {
		this.parent = parent;
	}

}
