/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.algorithms.graphs;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;
import org.junit.Test;

import java.util.*;

import static com.laranevans.cs.algorithms.graphs.Djikstra.DISTANCE;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DjikstraTest {

	@Test
	public void shouldFindShortestRoute() {
		String a = "a", b = "b", c = "c", d = "d";

		Graph graph = new Graph()
			.addNode(new GraphNode(a))
			.addNode(new GraphNode(b))
			.addNode(new GraphNode(c))
			.addNode(new GraphNode(d));

		// a -> b
		Map<String, String> aToBEdgeProperties = new HashMap<>();
		aToBEdgeProperties.put(DISTANCE, "10");
		graph.getNode(a).addEdgeTo(graph.getNode(b), aToBEdgeProperties);

		// a -> c
		Map<String, String> aToCEdgeProperties = new HashMap<>();
		aToCEdgeProperties.put(DISTANCE, "5");
		graph.getNode(a).addEdgeTo(graph.getNode(c), aToCEdgeProperties);

		// b -> d
		Map<String, String> bToDEdgeProperties = new HashMap<>();
		bToDEdgeProperties.put(DISTANCE, "7");
		graph.getNode(b).addEdgeTo(graph.getNode(d), bToDEdgeProperties);

		// c -> d
		Map<String, String> cToDEdgeProperties = new HashMap<>();
		cToDEdgeProperties.put(DISTANCE, "25");
		graph.getNode(c).addEdgeTo(graph.getNode(d), cToDEdgeProperties);

		Djikstra.Topology topology = Djikstra.analyze(graph, a);
		Djikstra.Route route = topology.shortestRouteBetween(a, d);

		List<String> actualPath = route.getSteps();
		List<String> expectedPath = Arrays.asList(a, b, d);

		assertThat(actualPath, equalTo(expectedPath));
	}

}
