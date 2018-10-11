/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

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

}
