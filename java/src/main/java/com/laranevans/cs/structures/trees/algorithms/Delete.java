/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

public class Delete {

	// Delete a value underneath a given root.
	public static <V extends Comparable> BinarySearchTreeNode<V> delete(BinarySearchTreeNode<V> root, V value) {
		// Recurse iteratively to the parent of the node to delete.
		// This helps to reduce the size of the call stack when deleting values deep in a tree.
		BinarySearchTreeNode<V> parent = Search.search(root, value).getParent();

		// Special handling for when deleting the value at the root node itself.
		if (parent == null) {
			// When the root has a right child, replace the value at the root with the minimum value in
			// the right sub-tree
			if (root.getRight() != null) {
				BinarySearchTreeNode<V> min = MinValue.minValue(root.getRight());
				if (min.getRight() != null) {
					root.setValue(min.getValue());
					min.getParent().setLeft(min.getRight());
				} else {
					root.setValue(min.getValue());
					min.getParent().setLeft(null);
				}
				return root;
			} else if (root.getLeft() != null) {
				root.getLeft().setParent(null);
				return root.getLeft();
			} else {
				// We're trying to delete a root node with no children.
				// Can't set value to null, so nothing we can do.
				return root;
			}
		}

		// It isn't the root. Delete normally.
		hibbard(parent, value);

		return root;
	}

	// Hibbard's algorithm
	private static <V extends Comparable> BinarySearchTreeNode<V> hibbard(BinarySearchTreeNode<V> root, V value) {
		if (root == null || value == null) {
			return null;
		}

		int comparison = value.compareTo(root.getValue());
		if (comparison < 0) {
			root.setLeft(hibbard(root.getLeft(), value));
		} else if (comparison > 0) {
			root.setRight(hibbard(root.getRight(), value));
		} else {
			if (root.getRight() == null) {
				return root.getLeft();
			} else if (root.getLeft() == null) {
				return root.getRight();
			}

			BinarySearchTreeNode<V> temp = root;
			root = MinValue.minValue(temp.getRight());
			root.setRight(deleteMin(temp.getRight()));
			root.setLeft(temp.getLeft());
		}

		return root;
	}

	private static <V extends Comparable> BinarySearchTreeNode<V> deleteMin(BinarySearchTreeNode<V> current) {
		if (current.getLeft() == null) {
			return current.getRight();
		}
		current.setLeft(deleteMin(current.getLeft()));
		return current;
	}

}
