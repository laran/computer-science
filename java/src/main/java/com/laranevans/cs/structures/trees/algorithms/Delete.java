/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees.algorithms;

import com.laranevans.cs.structures.trees.BinarySearchTreeNode;

public class Delete {

	public static <V extends Comparable> BinarySearchTreeNode<V> delete(BinarySearchTreeNode<V> current, V value) {
		if (current == null || value == null) {
			return null;
		}

		// Hibbard's algorithm
		int comparison = value.compareTo(current.getValue());
		if (comparison < 0) {
			current.setLeft(delete(current.getLeft(), value));
		} else if (comparison > 0) {
			current.setRight(delete(current.getRight(), value));
		} else {
			if (current.getRight() == null) {
				return current.getLeft();
			} else if (current.getLeft() == null) {
				return current.getRight();
			}

			BinarySearchTreeNode<V> temp = current;
			current = MinValue.minValue(temp.getRight());
			current.setRight(deleteMin(temp.getRight()));
			current.setLeft(temp.getLeft());
		}

		return current;
	}

	private static <V extends Comparable> BinarySearchTreeNode<V> deleteMin(BinarySearchTreeNode<V> current) {
		if (current.getLeft() == null) {
			return current.getRight();
		}
		current.setLeft(deleteMin(current.getLeft()));
		return current;
	}

}
