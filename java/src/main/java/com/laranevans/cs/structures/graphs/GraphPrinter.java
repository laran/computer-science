/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import com.laranevans.cs.structures.maps.MapHelper;
import com.laranevans.cs.structures.strings.StringHelper;

/**
 * A utility to print out a Graph in a standard, ordered format.
 */
public class GraphPrinter {
	public static void print(Graph graph) {
		graph.getNodes().keySet().stream()
			.sorted()
			.forEach(nodeId -> print(graph.getNode(nodeId)));
	}

	public static void print(GraphNode node) {
		println("GraphNode: id=", node.getId(), ", ",
			MapHelper.stringify(node.getProperties()));
		node.getEdges().keySet().stream()
			.sorted()
			.forEach(nodeId -> printEdge(nodeId, node.getEdges().get(nodeId)));
		println("");
	}

	public static void printEdge(String nodeId, GraphEdge edge) {
		println("--> Edge to ", nodeId, ": ",
			MapHelper.stringify(edge.getProperties()));
	}

	private static void println(String... strings) {
		System.out.println(StringHelper.concat(strings));
	}

}
