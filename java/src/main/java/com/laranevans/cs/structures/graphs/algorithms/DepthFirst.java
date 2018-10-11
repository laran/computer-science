/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DepthFirst {

	/**
	 *
	 * @param graph
	 * @param root
	 * @param matcher
	 * @return
	 */
	public static GraphNode searchRecursively(Graph graph, GraphNode root, GraphNodeMatcher matcher) {
		return searchRecursively(graph, root, matcher, new TreeSet<>());
	}

	/**
	 *
	 * @param graph
	 * @param root
	 * @param matcher
	 * @return
	 */
	public static GraphNode searchIteratively(Graph graph, GraphNode root, GraphNodeMatcher matcher) {
		return searchIteratively(graph, root, matcher, new TreeSet<>());
	}

	private static GraphNode searchRecursively(Graph graph, GraphNode root, GraphNodeMatcher matcher, Set<String> visitedNodes) {

		// Ensure we visit each node at most once.
		if (visitedNodes.contains(root.getId())) {
			return null;
		}

		// Remember that we visited this node
		visitedNodes.add(root.getId());

		// Does matcher match this node?
		if (matcher.matches(root)) {
			return root;
		}

		// If not, recurse to check all connected GraphNodes
		for (String connectedNodeId : root.getEdges().keySet()) {
			GraphNode match = searchRecursively(graph, graph.getNode(connectedNodeId), matcher, visitedNodes);
			if (match != null) {
				return match;
			}
		}

		// Oh well, we tried :/
		return null;
	}

	private static GraphNode searchIteratively(Graph graph, GraphNode root, GraphNodeMatcher matcher, Set<String> visitedNodes) {

		// Using a Stack makes it depth-first.
		// Replacing the Stack with a Queue would make it breadth-first.
		Stack<String> stack = new Stack<>();
		stack.push(root.getId());

		while(!stack.isEmpty()) {
			String nodeId = stack.pop();

			// Ensure we visit each node at most once.
			if(visitedNodes.contains(nodeId)) {
				continue;
			}

			// Remember that we visited this node
			visitedNodes.add(nodeId);

			// Does matcher match this node?
			GraphNode node = graph.getNode(nodeId);
			if (matcher.matches(node)) {
				return node;
			}

			// If not, push all neighbors onto the stack
			for(String neighborId:node.getEdges().keySet()) {
				stack.push(neighborId);
			}
		}

		// Oh well, we tried :/
		return null;
	}
}
