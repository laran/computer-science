/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists;

/**
 * A Node class for use as/in a doubly-linked list.
 */
public class DoublyLinkedListNode extends SinglyLinkedListNode {
	protected DoublyLinkedListNode previous;

	public DoublyLinkedListNode(Object value) {
		super(value);
	}

	public DoublyLinkedListNode(DoublyLinkedListNode previous, Object value, DoublyLinkedListNode next) {
		super(value, next);
		this.previous = previous;
	}

	public DoublyLinkedListNode getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode previous) {
		this.previous = previous;
	}
}
