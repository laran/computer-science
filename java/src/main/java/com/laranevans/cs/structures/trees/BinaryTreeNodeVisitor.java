/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

/**
 * Standard interface for operations to be executed while
 * traversing a BinaryTreeNode.
 */
public interface BinaryTreeNodeVisitor {
	/**
	 * Standard interface for visiting a node during any kind of
	 * traversal. Return true to exit traversal after visiting a
	 * given node (for example, if you implement this method to
	 * find a node with a given value, when you find the value
	 * you're looking for, return true to exit traversal and
	 * return that node).
	 *
	 * Traversal methods will return the Node it just visited
	 * when visit(BinaryTreeNode) return true.
	 *
	 * @param node
	 * @return true to exit traversal, false to continue traversal
	 */
	boolean visit(BinaryTreeNode node);
}
