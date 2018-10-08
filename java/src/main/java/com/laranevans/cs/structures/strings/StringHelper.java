/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.strings;

public class StringHelper {

	/**
	 * Concatenate a List of Strings
	 *
	 * @param strings
	 * @return
	 */
	public static String concat(String... strings) {
		StringBuilder builder = new StringBuilder();
		for (String s : strings) {
			builder.append(s);
		}
		return builder.toString();
	}

}
