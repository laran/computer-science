/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("A Graph")
public class GraphTest {

	@Test
	public void shouldAddNodesProperly() {
		String a = "a", b = "b", c = "c", d = "d";

		Graph graph = new Graph()
			.addNode(new GraphNode(a))
			.addNode(new GraphNode(b))
			.addNode(new GraphNode(c))
			.addNode(new GraphNode(d));

		// a -> b
		graph.getNode(a).addEdgeTo(graph.getNode(b));

		// a -> c
		graph.getNode(a).addEdgeTo(graph.getNode(c));

		// b -> d
		graph.getNode(b).addEdgeTo(graph.getNode(d));

		// c -> a
		graph.getNode(c).addEdgeTo(graph.getNode(a));

		assertThat(graph.getNode(a), notNullValue());
		assertThat(graph.getNode("e"), nullValue());

		assertThat(graph.getNode(a).isConnectedTo(b), is(true));
		assertThat(graph.getNode(a).isConnectedTo(c), is(true));
		assertThat(graph.getNode(b).isConnectedTo(d), is(true));
		assertThat(graph.getNode(c).isConnectedTo(a), is(true));

		assertThat(graph.getNode(d).isConnectedTo(b), is(false));

		assertThat(graph.getNode(a).getEdges().get(c), notNullValue());
		assertThat(graph.getNode(a).getEdges().get(d), nullValue());
	}
}
