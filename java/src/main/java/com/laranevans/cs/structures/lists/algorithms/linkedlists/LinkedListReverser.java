/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

/**
 * To reverse a LinkedList in real life you'd probably use java.util.LinkedList and
 * java.util.Collections.reverse(..).
 *
 * This is a stripped down version to show the basic algorithm.
 *
 * If you aren't familiar with Java, the Node class is defined in same package as this
 * class. You can browse the source on GitHub to take a look.
 */
public class LinkedListReverser {

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
