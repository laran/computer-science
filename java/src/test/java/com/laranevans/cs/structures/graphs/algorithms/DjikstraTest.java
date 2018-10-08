/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.laranevans.cs.structures.graphs.algorithms.Djikstra.DISTANCE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Djikstra's Algorithm")
public class DjikstraTest {

	@Test
	public void shouldFindTheShortestRoute() {
		String a = "a", b = "b", c = "c", d = "d";

		Graph graph = new Graph()
			.addNode(new GraphNode(a))
			.addNode(new GraphNode(b))
			.addNode(new GraphNode(c))
			.addNode(new GraphNode(d));

		// a -> b
		Map<String, String> aToBEdgeProperties = new HashMap<>();
		aToBEdgeProperties.put(DISTANCE, "10");
		graph.getNode(a).addDirectedEdgeTo(graph.getNode(b), aToBEdgeProperties);

		// a -> c
		Map<String, String> aToCEdgeProperties = new HashMap<>();
		aToCEdgeProperties.put(DISTANCE, "5");
		graph.getNode(a).addDirectedEdgeTo(graph.getNode(c), aToCEdgeProperties);

		// b -> d
		Map<String, String> bToDEdgeProperties = new HashMap<>();
		bToDEdgeProperties.put(DISTANCE, "7");
		graph.getNode(b).addDirectedEdgeTo(graph.getNode(d), bToDEdgeProperties);

		// c -> d
		Map<String, String> cToDEdgeProperties = new HashMap<>();
		cToDEdgeProperties.put(DISTANCE, "25");
		graph.getNode(c).addDirectedEdgeTo(graph.getNode(d), cToDEdgeProperties);

		Djikstra.Topology topology = Djikstra.analyze(graph, a);
		Djikstra.Route route = topology.shortestRouteBetween(a, d);

		List<String> actualPath = route.getSteps();
		List<String> expectedPath = Arrays.asList(a, b, d);

		assertThat(actualPath, equalTo(expectedPath));
	}

}
