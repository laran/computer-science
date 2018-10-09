/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.Collections;
import java.util.stream.Stream;

import static com.laranevans.cs.Letters.*;
import static com.laranevans.cs.structures.graphs.algorithms.Prims.DISTANCE;
import static com.laranevans.cs.structures.maps.MapHelper.entriesToMap;
import static com.laranevans.cs.structures.maps.MapHelper.entry;

/**
 * A set of known sample graphs.
 */
public class SampleGraphs {

	public static Graph letters() {
		Graph letters = new Graph();
		for(String s : new String[] {A, B, C, D, E, F, G}) {
			letters.addNode(new GraphNode(s));
		}

		GraphNode a = letters.getNode(A);
		GraphNode b = letters.getNode(B);
		GraphNode c = letters.getNode(C);
		GraphNode d = letters.getNode(D);
		GraphNode e = letters.getNode(E);
		GraphNode f = letters.getNode(F);
		GraphNode g = letters.getNode(G);

		a.addUndirectedEdgeTo(b, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "5")
		).collect(entriesToMap())));
		a.addUndirectedEdgeTo(c, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "1")
		).collect(entriesToMap())));
		a.addUndirectedEdgeTo(d, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "4")
		).collect(entriesToMap())));

		b.addUndirectedEdgeTo(d, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "8")
		).collect(entriesToMap())));
		b.addUndirectedEdgeTo(f, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "6")
		).collect(entriesToMap())));

		c.addUndirectedEdgeTo(e, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "2")
		).collect(entriesToMap())));
		c.addUndirectedEdgeTo(d, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "3")
		).collect(entriesToMap())));

		d.addUndirectedEdgeTo(f, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "8")
		).collect(entriesToMap())));

		e.addUndirectedEdgeTo(g, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "9")
		).collect(entriesToMap())));
		e.addUndirectedEdgeTo(f, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "7")
		).collect(entriesToMap())));

		return letters;
	}

	public static Graph cities() {
		Graph cities = new Graph();

		GraphNode newYork = new GraphNode("New York");
		GraphNode chicago = new GraphNode("Chicago");
		GraphNode london = new GraphNode("London");
		GraphNode sanFrancisco = new GraphNode("San Francisco");
		GraphNode newOrleans = new GraphNode("New Orleans");

		newYork.addUndirectedEdgeTo(chicago, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "789")
		).collect(entriesToMap())));

		newYork.addUndirectedEdgeTo(london, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "3459")
		).collect(entriesToMap())));

		newYork.addUndirectedEdgeTo(newOrleans, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "1304")
		).collect(entriesToMap())));

		newYork.addUndirectedEdgeTo(sanFrancisco, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "2902")
		).collect(entriesToMap())));

		chicago.addUndirectedEdgeTo(sanFrancisco, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "2127")
		).collect(entriesToMap())));

		chicago.addUndirectedEdgeTo(newOrleans, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "925")
		).collect(entriesToMap())));

		sanFrancisco.addUndirectedEdgeTo(newOrleans, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "2274")
		).collect(entriesToMap())));

		london.addUndirectedEdgeTo(sanFrancisco, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "5351")
		).collect(entriesToMap())));

		london.addUndirectedEdgeTo(chicago, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "3945")
		).collect(entriesToMap())));

		newOrleans.addUndirectedEdgeTo(london, Collections.unmodifiableMap(Stream.of(
			entry(DISTANCE, "4624")
		).collect(entriesToMap())));

		cities.addAll(newYork, chicago, london, sanFrancisco, newOrleans);
		return cities;
	}
}
