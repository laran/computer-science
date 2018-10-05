/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Breadth-first Search")
public class BreadthFirstTest {

	private Graph universe;
	private GraphNodeMatcher needleMatcher;
	private GraphNodeMatcher nothingMatcher;

	@BeforeEach
	public void setup() {
		// Let's construct a universe of things.

		universe = new Graph();

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

		// And a way to find both the needle and nothing.

		needleMatcher = node -> node.getId().equals("needle");
		nothingMatcher = node -> node.getId().equals("nothing");
	}

	@Test
	public void shouldFindAMatchRecursivelyWhenOneExists() {
		GraphNode foundNeedle = BreadthFirst.searchRecursively(universe, universe.getNode("thing"), needleMatcher);
		assertThat(foundNeedle, is(notNullValue()));
		assertThat(foundNeedle.getId(), is(equalTo(universe.getNode("needle").getId())));
	}

	@Test
	public void shouldNotFindAMatchRecursivelyWhenOneDoesntExist() {
		GraphNode foundNeedle = BreadthFirst.searchRecursively(universe, universe.getNode("thing"), nothingMatcher);
		assertThat(foundNeedle, is(nullValue()));
	}

	@Test
	public void shouldFindAMatchIterativelyWhenOneExists() {
		GraphNode foundNeedle = BreadthFirst.searchIteratively(universe, universe.getNode("thing"), needleMatcher);
		assertThat(foundNeedle, is(notNullValue()));
		assertThat(foundNeedle.getId(), is(equalTo(universe.getNode("needle").getId())));
	}

	@Test
	public void shouldNotFindAMatchIterativelyWhenOneDoesntExist() {
		GraphNode foundNeedle = BreadthFirst.searchIteratively(universe, universe.getNode("thing"), nothingMatcher);
		assertThat(foundNeedle, is(nullValue()));
	}

}
