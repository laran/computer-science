/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RemoveDuplicates {

	public static void from(SinglyLinkedListNode node) {
		Set<Object> seen = new HashSet<>();
		SinglyLinkedListNode previous = node;
		seen.add(previous.getValue());
		SinglyLinkedListNode current = previous.getNext();
		while (!Objects.isNull(current)) {
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
