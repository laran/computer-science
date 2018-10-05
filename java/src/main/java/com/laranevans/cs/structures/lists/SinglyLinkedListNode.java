/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists;

/**
 * A Node class for use as/in a singly-linked list.
 */
public class SinglyLinkedListNode {
	protected SinglyLinkedListNode next;
	protected Object value;

	public SinglyLinkedListNode(Object value) {
		this(value, null);
	}

	public SinglyLinkedListNode(Object value, SinglyLinkedListNode next) {
		this.next = next;
		this.value = value;
	}

	public SinglyLinkedListNode getNext() {
		return next;
	}

	public void setNext(SinglyLinkedListNode next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public int length() {
		int len = 1;
		SinglyLinkedListNode node = this;
		while((node = node.getNext()) != null) {
			len++;
		}
		return len;
	}
}
