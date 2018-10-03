/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

/**
 * To reverse a LinkedList in real life you'd probably use java.util.LinkedList and
 * java.util.Collections.reverse(..). This is a stripped down version to show the
 * basic algorithm.
 */
public class LinkedListReverser {

	/**
	 * A very basic Node class which we'll use to represent a LinkedList.
	 */
	static class Node {
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

	/**
	 *
	 * @param root
	 * @return the new head, which was previously the tail
	 */
	static Node reverse(Node root) {
		Node current = root;
		Node prev = null;
		while (current != null) {
			Node tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		return prev;
	}
}
