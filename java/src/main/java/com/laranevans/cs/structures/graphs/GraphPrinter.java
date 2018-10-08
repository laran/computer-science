/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.Map;
import java.util.TreeSet;

/**
 * A utility to print out a Graph in a standard, ordered format.
 */
public class GraphPrinter {

	private static String SEPARATOR = "-----------";

	static public void print(Graph graph) {
		TreeSet<String> sortedNodeIds = new TreeSet<>();
		sortedNodeIds.addAll(graph.getNodes().keySet());

		for(String nodeId : sortedNodeIds) {
			print(graph.getNode(nodeId));
		}
	}

	static private void print(GraphNode node) {
		println(SEPARATOR, "----");
		println(String.format("GraphNode: id=%s", node.getId()));
		println(SEPARATOR, "----");

		println(indent(1), "Properties:");
		println(indent(1), SEPARATOR);
		if (node.getProperties().keySet().isEmpty()) {
			println(indent(2), "None");
		} else {
			printMap(node.getProperties(), 2);
		}

		println(indent(1), SEPARATOR);
		println(indent(1), "Edges:");
		println(indent(1), SEPARATOR);

		if (node.getEdges().keySet().isEmpty()) {
			println(indent(2), "None");
		} else {
			TreeSet<String> sortedNodeIds = new TreeSet<>();
			sortedNodeIds.addAll(node.getEdges().keySet());

			for(String nodeId : sortedNodeIds) {
				printEdge(nodeId, node.getEdges().get(nodeId));
			}
		}
		println(indent(1), SEPARATOR, "\n");
	}

	static private void printEdge(String nodeId, GraphEdge edge) {
		println(indent(2), "-> ", nodeId);
		println(indent(2), SEPARATOR);
		println(indent(3), SEPARATOR);
		println(indent(3), "Properties:");
		println(indent(3), SEPARATOR);

		if(edge.getProperties().keySet().isEmpty()) {
			println(indent(4), "None");
		} else {
			printMap(edge.getProperties(), 4);
		}
		println(indent(3), SEPARATOR);
		println(indent(2), SEPARATOR);
	}

	static private void println(String... strings) {
		StringBuilder builder = new StringBuilder();
		for(String s : strings) {
			builder.append(s);
		}
		System.out.println(builder.toString());
	}

	static private void printMap(Map<String,String> properties, int indent) {
		StringBuilder b = new StringBuilder();
		TreeSet<String> sortedNames = new TreeSet<>();
		sortedNames.addAll(properties.keySet());

		for (String name : sortedNames) {
			println(indent(indent), String.format(
				"%s: %s", name, properties.get(name)));

		}
	}

	static private String indent(int indent) {
		return indent(indent, '\t');
	}

	static private String indent(int indent, char c) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < indent; i++) {
			builder.append(c);
		}
		return builder.toString();
	}

}
