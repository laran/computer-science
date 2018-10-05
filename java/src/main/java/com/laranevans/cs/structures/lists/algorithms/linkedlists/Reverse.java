/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.List;

/**
 * To of a LinkedList in real life you'd probably use
 * {@link java.util.LinkedList} and {@link java.util.Collections#reverse(List)}.
 * <p>
 * This is a stripped down version to show the basic algorithm.
 */
public class Reverse {

	/**
	 * @param head
	 * @return the new head, which was previously the tail
	 */
	public static SinglyLinkedListNode of(SinglyLinkedListNode head) {
		SinglyLinkedListNode current = head;
		SinglyLinkedListNode prev = null;
		while (current != null) {
			SinglyLinkedListNode tmp = current.getNext();
			current.setNext(prev);
			prev = current;
			current = tmp;
		}
		return prev;
	}
}
