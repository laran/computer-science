/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinaryTreeNode;

import java.util.Objects;

public class Rotate {

	/**
	 *
	 * @return the node that rotated into the same position
	 */
	public static BinaryTreeNode left(BinaryTreeNode node) {
		if (Objects.isNull(node.getRight())) {
			return node;
		}

		BinaryTreeNode oldRoot = node;
		BinaryTreeNode newRoot = node.getRight();
		oldRoot.setRight(newRoot.getLeft(), false);
		if (!Objects.isNull(newRoot.getLeft())) {
			newRoot.getLeft().setParent(oldRoot);
		}
		newRoot.setParent(oldRoot.getParent());
		if (!Objects.isNull(oldRoot.getParent())) {
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
	 * @return the node that rotated into the same position
	 */
	public static BinaryTreeNode right(BinaryTreeNode node) {
		if (Objects.isNull(node.getLeft())) {
			return node;
		}

		BinaryTreeNode oldRoot = node;
		BinaryTreeNode newRoot = node.getLeft();
		oldRoot.setLeft(newRoot.getRight(), false);
		if (!Objects.isNull(newRoot.getRight())) {
			newRoot.getRight().setParent(oldRoot);
		}
		newRoot.setParent(oldRoot.getParent());
		if (!Objects.isNull(oldRoot.getParent())) {
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
