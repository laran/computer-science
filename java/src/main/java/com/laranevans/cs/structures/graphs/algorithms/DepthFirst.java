/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DepthFirst {

	public static GraphNode search(Graph graph, GraphNode root, GraphNodeMatcher matcher) {
		return search(graph, root, matcher, new TreeSet<>());
	}

	private static GraphNode search(Graph graph, GraphNode root, GraphNodeMatcher matcher, Set<String> visitedNodes) {

		// Ensure we visit each node exactly once.
		if (visitedNodes.contains(root.getId())) {
			return null;
		}

		// Does it match this node?
		if (matcher.matches(root)) {
			return root;
		}

		// If not, remember that we visited this node ...
		visitedNodes.add(root.getId());

		// ... and recurse to check all connected GraphNodes
		for (String connectedNodeId : root.getEdges().keySet()) {
			GraphNode match = search(graph, graph.getNode(connectedNodeId), matcher, visitedNodes);
			if (!Objects.isNull(match)) {
				return match;
			}
		}

		// Oh well, we tried :/
		return null;
	}

}
