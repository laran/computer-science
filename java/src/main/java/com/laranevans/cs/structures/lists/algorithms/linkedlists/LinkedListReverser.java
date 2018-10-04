/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.LinkedListNode;

/**
 * To reverse a LinkedList in real life you'd probably use java.util.LinkedList
 * and java.util.Collections.reverse(..).
 *
 * This is a stripped down version to show the basic algorithm.
 */
public class LinkedListReverser {

	/**
	 *
	 * @param root
	 * @return the new head, which was previously the tail
	 */
	static LinkedListNode reverse(LinkedListNode root) {
		LinkedListNode current = root;
		LinkedListNode prev = null;
		while (current != null) {
			LinkedListNode tmp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = tmp;
		}
		return prev;
	}
}
