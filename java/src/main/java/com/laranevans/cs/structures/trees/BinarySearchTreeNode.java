/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.Arrays;
import java.util.Objects;

public class BinarySearchTreeNode<V extends Comparable> extends BinaryTreeNode {
	public BinarySearchTreeNode(V value) {
		super(value);
	}

	public BinarySearchTreeNode insert(V value) {
		if(Objects.isNull(value)) {
			return this;
		}

		BinarySearchTreeNode node = this;
		while (!Objects.isNull(node)) {
			if (value.compareTo(node.getValue()) == 0) {
				return node; // value already exists
			} else if (value.compareTo(node.getValue()) < 0) {
				if (Objects.isNull(node.getLeft())) {
					node.setLeft(new BinarySearchTreeNode(value));
					break;
				} else {
					node = (BinarySearchTreeNode) node.getLeft();
				}
			} else {
				if (Objects.isNull(node.getRight())) {
					node.setRight(new BinarySearchTreeNode(value));
					break;
				} else {
					node = (BinarySearchTreeNode) node.getRight();
				}
			}
		}
		return this;
	}

	public BinarySearchTreeNode insertAll(V... values) {
		Arrays.stream(values).forEach(this::insert);
		return this;
	}

	public BinarySearchTreeNode searchDepthFirst(V value) {
		if (Objects.isNull(value)) {
			return null;
		}

		BinarySearchTreeNode node = this;
		while (!Objects.isNull(node)) {
			if (value.compareTo(node.getValue()) == 0) {
				return node;
			} else if (value.compareTo(node.getValue()) > 0) {
				node = (BinarySearchTreeNode) node.getRight();
			} else {
				node = (BinarySearchTreeNode) node.getLeft();
			}
		}
		return node;
	}

}
