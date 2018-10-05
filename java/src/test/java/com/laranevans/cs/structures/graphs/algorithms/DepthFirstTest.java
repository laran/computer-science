/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("DepthFirstSearch")
public class DepthFirstTest {

	public static String VALUE = "value";

	@Test
	public void shouldFindAMatch() {
		GraphNodeMatcher matcher = new GraphNodeMatcher() {
			@Override
			public boolean matches(GraphNode node) {
				return node.getId().equals("needle");
			}
		};

		// Let's construct a universe of things.

		Graph universe = new Graph();

		GraphNode apple = new GraphNode("apple");
		GraphNode orange = new GraphNode("orange");

		GraphNode fruit = new GraphNode("fruit");
		fruit.addEdgesTo(apple, orange);

		GraphNode needle = new GraphNode("needle");

		GraphNode metalThing = new GraphNode("metalThing");
		metalThing.addEdgeTo(needle);

		GraphNode thing = new GraphNode("thing");
		thing.addEdgesTo(fruit, metalThing); // needle is a thing

		universe.addAll(apple, orange, fruit, thing, metalThing, needle);

		// OK. Now go find the needle!

		GraphNode foundNeedle = DepthFirst.search(universe, thing, matcher);
		assertThat(foundNeedle, is(notNullValue()));
		assertThat(foundNeedle.getId(), is(equalTo(needle.getId())));

	}
}
