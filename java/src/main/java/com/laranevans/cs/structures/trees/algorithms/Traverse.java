/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;
import com.laranevans.cs.structures.trees.BinaryTreeNode;
import com.laranevans.cs.structures.trees.BinarySearchTreeNodeVisitor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * All types of BinaryTreeNode traversal, all implemented iteratively
 * (to avoid the call stack overhead incurred by recursion, particularly on large trees)
 */
public class Traverse {

	/**
	 * Pre-order, depth-first traversal
	 *
	 * @param root
	 * @param visitor
	 * @return
	 */
	public static <V extends Comparable> BinarySearchTreeNode<V> preOrder(BinarySearchTreeNode<V> root, BinarySearchTreeNodeVisitor visitor) {
		if (root == null) {
			return null;
		}

		Stack<BinarySearchTreeNode<V>> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			BinarySearchTreeNode<V> node = stack.pop();
			if (visitor.visit(node)) {
				return node;
			} else {
				// Visit right child ...
				if (node.getRight() != null) {
					stack.push(node.getRight());
				}
				// ... then left child
				if (node.getLeft() != null) {
					stack.push(node.getLeft());
				}
			}
		}

		return null;
	}

	/**
	 * In-order, depth-first traversal.
	 *
	 * Applies only to BinarySearchTreeNode because a basic BinaryTree has no ordering constraint regarding
	 * the relation between a node and it's left and right child.
	 *
	 * @param root (restricted to BinarySearchTreeNode, not just BinaryTreeNode)
	 * @param visitor
	 * @return
	 */
	public static <V extends Comparable> BinarySearchTreeNode inOrder(BinarySearchTreeNode<V> root, BinarySearchTreeNodeVisitor visitor) {
		if (root == null) {
			return null;
		}

		Stack<BinarySearchTreeNode> stack = new Stack<>();
		BinarySearchTreeNode node = root;

		while(node != null || !stack.isEmpty()) {

			if(node != null) {
				stack.push(node);
				node = node.getLeft();
			} else {
				node = stack.pop();
				if (visitor.visit(node)) {
					return node;
				} else {
					node = node.getRight();
				}
			}
		}

		return null;
	}

	/**
	 * Post-order, depth-first traversal
	 *
	 * @param root
	 * @param visitor
	 * @return
	 */
	public static <V extends Comparable> BinarySearchTreeNode<V> postOrder(BinarySearchTreeNode<V> root, BinarySearchTreeNodeVisitor visitor) {
		if (root == null) {
			return null;
		}

		// I chose the two-stack solution because it's relatively easy to understand and code.
		Stack<BinarySearchTreeNode<V>> stackOne = new Stack<>();
		Stack<BinarySearchTreeNode<V>> stackTwo = new Stack<>();

		stackOne.push(root);

		while(!stackOne.isEmpty()) {
			BinarySearchTreeNode<V> node = stackOne.pop();
			stackTwo.push(node);

			if (node.getLeft() != null) {
				stackOne.push(node.getLeft());
			}
			if (node.getRight() != null) {
				stackOne.push(node.getRight());
			}
		}

		while (!stackTwo.isEmpty()) {
			BinarySearchTreeNode<V> node = stackTwo.pop();
			if (visitor.visit(node)) {
				return node;
			}
		}

		return null;
	}

	// Level-order (breadth-first) traversal
	public static <V extends Comparable> BinarySearchTreeNode<V> levelOrder(BinarySearchTreeNode<V> root, BinarySearchTreeNodeVisitor visitor) {
		if (root == null) {
			return null;
		}

		Queue<BinarySearchTreeNode<V>> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			BinarySearchTreeNode<V> node = q.poll();
			if (visitor.visit(node)) {
				return node;
			} else {
				if (node.getLeft() != null) {
					q.add(node.getLeft());
				}
				if (node.getRight() != null) {
					q.add(node.getRight());
				}
			}
		}

		return null;
	}

}
