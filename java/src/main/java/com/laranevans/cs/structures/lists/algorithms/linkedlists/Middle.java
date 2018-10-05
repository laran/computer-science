/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.Objects;

public class Middle {

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
		int slowPointerIndex = 0;

		while (!Objects.isNull(fastPointer) && !Objects.isNull(fastPointer.getNext())) {
			fastPointer = fastPointer.getNext().getNext();
			laggingPointer = slowPointer;
			slowPointer = slowPointer.getNext();
			slowPointerIndex++;
		}

		if (Objects.isNull(fastPointer)) {
			// even number of elements, return nodes before and after middle
			return new Result(laggingPointer, slowPointer, slowPointerIndex);
		}

		// odd number of elements, return exact middle
		return new Result(slowPointer, slowPointerIndex);
	}

	/**
	 * This class captures whether:
	 *
	 * - the exact middle was found (because the list had an odd number of elements)
	 * - the elements adjacent to the middle need to be used (because the list had an even number of elements)
	 *
	 * This allows us to more easily and intuitively be aware of and work with these cases.
	 */
	public static class Result {
		private ResultNodeInfo exactly;
		private ResultNodeInfo before;
		private ResultNodeInfo after;

		public Result(SinglyLinkedListNode exactly, int position) {
			this.exactly = new ResultNodeInfo(exactly, position);
		}

		public Result(SinglyLinkedListNode before, SinglyLinkedListNode after, int slowPointerIndex) {
			this.before = new ResultNodeInfo(before, slowPointerIndex - 1);
			this.after = new ResultNodeInfo(after, slowPointerIndex);
		}

		public ResultNodeInfo getExactly() {
			return exactly;
		}

		public ResultNodeInfo getBefore() {
			return before;
		}

		public ResultNodeInfo getAfter() {
			return after;
		}
	}

	/**
	 * The class allows us to capture both the node and the index at which it exists in the list.
	 */
	public static class ResultNodeInfo {
		private SinglyLinkedListNode node;
		private Integer position;

		public ResultNodeInfo(SinglyLinkedListNode node, Integer position) {
			this.node = node;
			this.position = position;
		}

		public SinglyLinkedListNode getNode() {
			return node;
		}

		public Integer getPosition() {
			return position;
		}
	}

}
