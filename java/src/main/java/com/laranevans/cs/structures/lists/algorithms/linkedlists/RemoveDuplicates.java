/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	/**
	 * Remove duplicates from a singly-linked list.
	 *
	 * @param head
	 */
	public static void from(SinglyLinkedListNode head) {
		Set<Object> seen = new HashSet<>();
		SinglyLinkedListNode previous = head;
		seen.add(previous.getValue());
		SinglyLinkedListNode current = previous.getNext();
		while (current != null) {
			if (seen.contains(current.getValue())) {
				previous.setNext(current.getNext()); // remove the duplicate by skipping over it
				current = previous;
			} else {
				seen.add(current.getValue());
			}
			previous = current;
			current = current.getNext();
		}
	}
}
