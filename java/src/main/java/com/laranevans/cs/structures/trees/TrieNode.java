/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

/**
 * Standard interface for a TrieNode.
 */
public interface TrieNode {

	boolean isWord();
	Character getValue();
	TrieNode add(String word);
	TrieNode contains(String word);

}
