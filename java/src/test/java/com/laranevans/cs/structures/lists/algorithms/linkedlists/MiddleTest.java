/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.lists.algorithms.linkedlists;

import com.laranevans.cs.structures.lists.SinglyLinkedListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Middle")
public class MiddleTest {

	@Test
	public void shouldFindTheExactMiddleWithAnOddLength() {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(3)));
		Middle.Result result = Middle.of(head);
		assertThat(result.getExactly(), is(notNullValue()));
		assertThat(result.getExactly().getNode().getValue(), is(equalTo(2)));
		assertThat(result.getExactly().getPosition(), is(equalTo(1)));
		assertThat(result.getBefore(), is(nullValue()));
		assertThat(result.getAfter(), is(nullValue()));
	}

	@Test
	public void shouldFindTheNodesAdjacentToMiddleWithAnEvenLength() {
		SinglyLinkedListNode head = new SinglyLinkedListNode(1,
			new SinglyLinkedListNode(2,
				new SinglyLinkedListNode(3,
					new SinglyLinkedListNode(4))));
		Middle.Result result = Middle.of(head);
		assertThat(result.getExactly(), is(nullValue()));
		assertThat(result.getBefore(), is(notNullValue()));
		assertThat(result.getBefore().getNode().getValue(), is(equalTo(2)));
		assertThat(result.getBefore().getPosition(), is(equalTo(1)));
		assertThat(result.getAfter(), is(notNullValue()));
		assertThat(result.getAfter().getNode().getValue(), is(equalTo(3)));
		assertThat(result.getAfter().getPosition(), is(equalTo(2)));
	}

}
