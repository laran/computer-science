/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Remove duplicates from a Singly Linked List")
public class RemoveDuplicatesTest {

	@Test
	public void shouldHandleDuplicates() {
		SinglyLinkedListNode node = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(1)));
		assertThat(node.length(), is(equalTo(3)));
		RemoveDuplicates.from(node);
		assertThat(node.getValue(), is(equalTo(1)));
		assertThat(node.getNext().getValue(), is(equalTo(2)));
		assertThat(node.getNext().getNext(), is(nullValue()));
		assertThat(node.length(), is(equalTo(2)));
	}
}
