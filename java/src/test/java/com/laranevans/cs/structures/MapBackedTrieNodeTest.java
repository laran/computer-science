/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures;

import com.laranevans.cs.structures.trees.MapBackedTrieNode;
import com.laranevans.cs.structures.trees.TrieNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("MapBackedTrieNode")
public class MapBackedTrieNodeTest {

	private TrieNode root;

	@BeforeEach
	public void setup() {
		this.root = new MapBackedTrieNode();
	}

	@Test
	public void shouldPassSanityCheck() {
		// root node should not have a value
		assertThat(root.getValue(), nullValue());

		root.add("sweet");
		assertThat(root.contains("sweet"), notNullValue());

		root.add("sweat");
		assertThat(root.contains("sweet"), notNullValue());

		// ensure that we can get a node for a prefix
		TrieNode swe = root.contains("swe");
		assertThat(swe.isWord(), equalTo(false));
		assertThat(swe.getValue(), equalTo('e'));

		// ensure that we can get prefixes further toward a word than the first prefix
		TrieNode swee = swe.contains("e");
		assertThat(swee.isWord(), equalTo(false));

		// ensure that we can get nodes for words that end in that prefix
		TrieNode sweet = swe.contains("et");
		assertThat(sweet, notNullValue());
		assertThat(sweet.isWord(), equalTo(true));

		TrieNode sweat = swe.contains("at");
		assertThat(sweat, notNullValue());
		assertThat(sweat.isWord(), equalTo(true));
	}

}
