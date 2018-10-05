/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;

import java.util.Objects;

/**
 * In order to check for a palindrome, we first need to be able
 * to find the middle of a linked list. See {@link Middle},
 * which we'll use here to meet that need.
 */
public class Palindrome {

	/**
	 * This solution runs in O(n) time and O(1) space.
	 * The way this is implemented, it does modify the list in order to check for the palindrom condition.
	 * This would probably not be appropriate in real life. It does revert the list before returning though.
	 *
	 *
	 * @param head
	 * @return
	 */
	public static boolean appliesTo(SinglyLinkedListNode head) {
		Middle.Result middle = Middle.of(head);

		SinglyLinkedListNode rightHead;

		if(Objects.isNull(middle.getExactly())) {
			// List has an even number of Nodes
			rightHead = middle.getAfter().getNode();
		} else {
			// List has an odd number of Nodes
			rightHead = middle.getExactly().getNode();
		}

		// reverse the right half of the list
		rightHead = Reverse.of(rightHead);

		// remember which node is the actual right head so we can reverse the right half later.
		SinglyLinkedListNode originalRightHead = rightHead;

		// walk the left and right sides in sequence to check equality
		boolean isAPalindrome = true;
		while(!Objects.isNull(rightHead)) {
			if (!head.getValue().equals(rightHead.getValue())) {
				isAPalindrome = false;
				break;
			}
			head = head.getNext();
			rightHead = rightHead.getNext();
		}

		// reverse the right half again to put it back in original order
		Reverse.of(originalRightHead);

		return isAPalindrome;
	}

}
