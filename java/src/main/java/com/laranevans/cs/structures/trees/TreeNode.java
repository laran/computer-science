/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic TreeNode for an unrestricted Tree.
 * This does NOT meet the criteria for a Binary Tree.
 * See {@link BinaryTreeNode} for that.
 *
 * @param &lt;V&gt;
 */
public class TreeNode<V extends Comparable> {
	protected V value;
	protected List<TreeNode<V>> children;

	public TreeNode(V value) {
		this(value, new ArrayList<TreeNode<V>>());
	}

	public TreeNode(V value, List<TreeNode<V>> children) {
		this.value = value;
		this.children = children;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public List<TreeNode<V>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<V>> children) {
		this.children = children;
	}
}
