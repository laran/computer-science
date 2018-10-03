/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListReverserTest {

	@Test
	public void shouldReverseUsingIterator() {
		// Build a Linked List
		Node head =
			new Node(1,
				new Node(2,
					new Node(3,
						new Node(4))));

		// Reverse it, getting the new head.
		Node newHead = LinkedListReverser.reverse(head);

		// Iterate the Nodes to collect their values.
		List<Object> list = new ArrayList<>();
		do {
			list.add(newHead.value);
			newHead = newHead.next;
		} while (newHead != null);

		// Voila!
		Assert.assertThat(list, Matchers.equalTo(Arrays.asList(4, 3, 2, 1)));
	}
}
