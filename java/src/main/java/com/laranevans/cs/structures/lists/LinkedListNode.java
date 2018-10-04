/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists;

/**
 * A very basic LinkedListNode class which we'll use to represent a LinkedList.
 */
public class LinkedListNode {
	protected LinkedListNode next;
	protected Object value;

	public LinkedListNode(Object value) {
		this(value, null);
	}

	public LinkedListNode(Object value, LinkedListNode next) {
		this.next = next;
		this.value = value;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
