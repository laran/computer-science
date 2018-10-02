/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.strings.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	/**
	 * Return all permutations of a String.
	 *
	 * @param s
	 * @return a List instead of a Set just to show that the algorithm isn't erroneously introducing
	 *         duplicates that the Set is then filtering out
	 */
	public List<String> permute(String s) {
		List<String> results = new ArrayList<>();
		permute(s.toCharArray(), 0, s.length()-1, results);
		return results;
	}

	private void permute(char[] a, int lo, int hi, List<String> results) {
		if (lo >= hi) { // we've fully permuted the string
			results.add(new String(a));
			return; // we're done
		}

		for (int i = lo; i <= hi; i++) {
			swap(a, lo, i); // lo and i will be the same on the first iteration. that's ok.
			permute(a, lo+1, hi, results);
			swap(a, lo, i);
		}
	}

	private void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
