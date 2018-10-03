/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

/**
 * A very basic Node class which we'll use to represent a LinkedList.
 */
class Node {
	Node next;
	Object value;

	public Node(Object value) {
		this.value = value;
	}

	public Node(Object value, Node next) {
		this.next = next;
		this.value = value;
	}
}
