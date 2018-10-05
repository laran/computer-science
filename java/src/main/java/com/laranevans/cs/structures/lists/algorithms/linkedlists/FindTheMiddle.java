/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.Objects;

public class FindTheMiddle {

	public static class Result {
		private SinglyLinkedListNode exactly;
		private SinglyLinkedListNode before;
		private SinglyLinkedListNode after;

		public Result(SinglyLinkedListNode exactly) {
			this.exactly = exactly;
		}

		public Result(SinglyLinkedListNode before, SinglyLinkedListNode after) {
			this.before = before;
			this.after = after;
		}

		public SinglyLinkedListNode getExactly() {
			return exactly;
		}

		public SinglyLinkedListNode getBefore() {
			return before;
		}

		public SinglyLinkedListNode getAfter() {
			return after;
		}
	}

	/**
	 * Uses the "runner method" to find the middle.
	 * One pointer moves two nodes at a time.
	 * Another pointer moves one node at a time.
	 * When the fast pointer reaches the end, the slow pointer is at the middle.
	 *
	 * In order to be able to return either the exact middle or the elements adjacent
	 * to the middle on either side (when the list has an even number of elements), a
	 * third pointer (a lagging pointer) is used to track one element behind the slow pointer.
	 *
	 * @param head
	 * @return Result with either the exact location or the nodes adjacent to the middle
	 */
	public static Result of(SinglyLinkedListNode head) {
		SinglyLinkedListNode slowPointer = head;
		SinglyLinkedListNode fastPointer = head;
		SinglyLinkedListNode laggingPointer = head;

		while (!Objects.isNull(fastPointer) && !Objects.isNull(fastPointer.getNext())) {
			fastPointer = fastPointer.getNext().getNext();
			laggingPointer = slowPointer;
			slowPointer = slowPointer.getNext();
		}

		if (Objects.isNull(fastPointer)) {
			// even number of elements, return nodes before and after middle
			return new Result(laggingPointer, slowPointer);
		}

		// odd number of elements, return exact middle
		return new Result(slowPointer);
	}

}
