/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Palindrome")
public class PalindromeTest {

	@Test
	public void shouldSupportEvenLengthLists() {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(3,
					new SinglyLinkedListNode(4))));
		boolean result = Palindrome.appliesTo(head);
		assertThat("A non-palindrome should not match", result, is(equalTo(false)));

		// ensure that the original list order is retained
		assertThat(head.getValue(), is(equalTo(1)));
		assertThat(head.getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getValue(), is(equalTo(3)));
		assertThat(head.getNext().getNext().getNext().getValue(), is(equalTo(4)));

		head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(2,
					new SinglyLinkedListNode(1))));
		result = Palindrome.appliesTo(head);
		assertThat("A palindrome should match", result, is(equalTo(true)));

		// ensure that the original list order is retained
		assertThat(head.getValue(), is(equalTo(1)));
		assertThat(head.getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getNext().getValue(), is(equalTo(1)));
	}

	@Test
	public void shouldSupportOddLengthLists() {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(3,
					new SinglyLinkedListNode(4,
						new SinglyLinkedListNode(5)))));
		boolean result = Palindrome.appliesTo(head);
		assertThat("A non-palindrome should not match", result, is(equalTo(false)));

		// ensure that the original list order is retained
		assertThat(head.getValue(), is(equalTo(1)));
		assertThat(head.getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getValue(), is(equalTo(3)));
		assertThat(head.getNext().getNext().getNext().getValue(), is(equalTo(4)));
		assertThat(head.getNext().getNext().getNext().getNext().getValue(), is(equalTo(5)));

		head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(3,
					new SinglyLinkedListNode(2,
						new SinglyLinkedListNode(1)))));
		result = Palindrome.appliesTo(head);
		assertThat("A palindrome should match", result, is(equalTo(true)));

		// ensure that the original list order is retained
		assertThat(head.getValue(), is(equalTo(1)));
		assertThat(head.getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getValue(), is(equalTo(3)));
		assertThat(head.getNext().getNext().getNext().getValue(), is(equalTo(2)));
		assertThat(head.getNext().getNext().getNext().getNext().getValue(), is(equalTo(1)));
	}
}
