/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapBackedTrieNode implements TrieNode {
	private Character value;
	private Map<Character, MapBackedTrieNode> children;

	/**
	 * Default constructor is public to allow creation of root node.
	 * Once the root is created, {@link MapBackedTrieNode#add(String)}
	 * should be used to add nodes under the root.
	 */
	public MapBackedTrieNode() {
		this(null);
	}

	private MapBackedTrieNode(Character value) {
		this(value, new HashMap<>());
	}

	private MapBackedTrieNode(Character value, Map<Character, MapBackedTrieNode> children) {
		this.value = value;
		this.children = children;
	}

	@Override
	public boolean isWord() {
		return children.containsKey(TrieNode.WORD_TERMINATOR);
	}

	@Override
	public Character getValue() {
		return value;
	}

	@Override
	public TrieNode add(String word) {
		MapBackedTrieNode node = this;
		for(int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (!node.children.containsKey(c)) {
				node.children.put(c, new MapBackedTrieNode(c));
			}
			node = node.children.get(c);
		}
		node.children.put(TrieNode.WORD_TERMINATOR, null);
		return node;
	}

	@Override
	public TrieNode contains(String word) {
		MapBackedTrieNode node = this;
		for(int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (!node.children.containsKey(c)) {
				return null;
			}
			node = node.children.get(c);
		}
		return node;
	}
}
