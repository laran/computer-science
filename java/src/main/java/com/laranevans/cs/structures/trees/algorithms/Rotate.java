/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinaryTreeNode;

/**
 * Left and right rotations for BinaryTreeNodes.
 */
public class Rotate {

	/**
	 *
	 * @param node
	 * @return the node that rotated into the same position as node
	 */
	public static BinaryTreeNode left(BinaryTreeNode node) {
		if (node.getRight() == null) {
			return node;
		}

		BinaryTreeNode oldRoot = node;
		BinaryTreeNode newRoot = node.getRight();
		oldRoot.setRight(newRoot.getLeft(), false);
		if (newRoot.getLeft() != null) {
			newRoot.getLeft().setParent(oldRoot);
		}
		newRoot.setParent(oldRoot.getParent());
		if (oldRoot.getParent() != null) {
			if (oldRoot == oldRoot.getParent().getLeft()) {
				oldRoot.getParent().setLeft(newRoot, false);
			} else {
				oldRoot.getParent().setRight(newRoot, false);
			}
		}
		newRoot.setLeft(oldRoot, false);
		oldRoot.setParent(newRoot);
		return newRoot;
	}

	/**
	 *
	 * @param node
	 * @return the node that rotated into the same position as node
	 */
	public static BinaryTreeNode right(BinaryTreeNode node) {
		if (node.getLeft() == null) {
			return node;
		}

		BinaryTreeNode oldRoot = node;
		BinaryTreeNode newRoot = node.getLeft();
		oldRoot.setLeft(newRoot.getRight(), false);
		if (newRoot.getRight() != null) {
			newRoot.getRight().setParent(oldRoot);
		}
		newRoot.setParent(oldRoot.getParent());
		if (oldRoot.getParent() != null) {
			if (oldRoot == oldRoot.getParent().getRight()) {
				oldRoot.getParent().setRight(newRoot, false);
			} else {
				oldRoot.getParent().setLeft(newRoot, false);
			}
		}
		newRoot.setRight(oldRoot, false);
		oldRoot.setParent(newRoot);
		return newRoot;
	}

}
