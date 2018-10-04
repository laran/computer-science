/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists;

/**
 * A very basic LinkedListNode class which we'll use to represent a LinkedList.
 */
public class LinkedListNode {
	public LinkedListNode next;
	public Object value;

	public LinkedListNode(Object value) {
		this.value = value;
	}

	public LinkedListNode(Object value, LinkedListNode next) {
		this.next = next;
		this.value = value;
	}
}
