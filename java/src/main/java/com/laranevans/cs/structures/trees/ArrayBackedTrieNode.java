/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.trees;

/**
 * A TrieNode backed by an array that supports an arbitrarily large set of characters.
 *
 * In comparison to the {@link MapBackedTrieNode}, because this class uses an array,
 * the children likely have better locality in memory and are therefore cached better,
 * making it faster to read.
 *
 * This class defaults to using 256 characters to support the ASCII alphabet.
 *
 * The 0-th element of the array represents the word terminator. This makes sense
 * because the 0-th character in the unicode character table is the null character.
 */
public class ArrayBackedTrieNode implements TrieNode {

	private static Integer SIZE_OF_ASCII_ALPHABET = 256;

	private Character value;

	private ArrayBackedTrieNode[] children;

	public ArrayBackedTrieNode() {
		this(SIZE_OF_ASCII_ALPHABET);
	}

	public ArrayBackedTrieNode(Integer sizeOfAlphabet) {
		this(null, sizeOfAlphabet);
	}

	private ArrayBackedTrieNode(Character value, Integer sizeOfAlphabet) {
		this.value = value;
		this.children = new ArrayBackedTrieNode[sizeOfAlphabet];
	}

	@Override
	public boolean isWord() {
		// The first bit is always the word terminator.
		// It corresponds to the null character in the unicode character table.
		return this.children[0] != null;
	}

	@Override
	public Character getValue() {
		return value;
	}

	@Override
	public TrieNode add(String word) {
		ArrayBackedTrieNode node = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c] == null) {
				node.children[c] = new ArrayBackedTrieNode(c, node.children.length);
			}
			node = node.children[c];
		}

		node.children[0] = new ArrayBackedTrieNode('\0', 0); // set the word terminator bit
		return node;
	}

	@Override
	public TrieNode contains(String word) {
		ArrayBackedTrieNode node = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c] == null) {
				return null;
			}
			node = node.children[c];
		}
		return node;
	}
}
