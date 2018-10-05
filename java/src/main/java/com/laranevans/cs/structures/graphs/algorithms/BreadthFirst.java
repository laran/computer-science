/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.*;

public class BreadthFirst {

	/**
	 *
	 * @param graph
	 * @param root
	 * @param matcher
	 * @return
	 */
	public static GraphNode searchRecursively(Graph graph, GraphNode root, GraphNodeMatcher matcher) {
		Queue<String> q = new ArrayDeque<>();
		q.offer(root.getId());
		return searchRecursively(graph, q, matcher, new TreeSet<>());
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

	private static GraphNode searchRecursively(Graph graph, Queue<String> q, GraphNodeMatcher matcher, Set<String> visitedNodes) {

		if (q.isEmpty()) {
			return null;
		}

		GraphNode node = graph.getNode(q.poll());

		// Ensure we visit each node at most once.
		if (visitedNodes.contains(node.getId())) {
			return null;
		}

		// Remember that we visited this node
		visitedNodes.add(node.getId());

		// Does matcher match this node?
		if (matcher.matches(node)) {
			return node;
		}

		// If not, recurse to check all connected GraphNodes
		for (String connectedNodeId : node.getEdges().keySet()) {
			q.offer(connectedNodeId);
		}

		// Oh well, we tried :/
		return searchRecursively(graph, q, matcher, visitedNodes);
	}

	private static GraphNode searchIteratively(Graph graph, GraphNode root, GraphNodeMatcher matcher, Set<String> visitedNodes) {

		// Using a Queue makes it breadth-first.
		// Replacing the Queue with a Stack would make it depth-first.
		Queue<String> q = new ArrayDeque<>();
		q.offer(root.getId());

		while(!q.isEmpty()) {
			String nodeId = q.poll();

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
				q.offer(neighborId);
			}
		}

		// Oh well, we tried :/
		return null;
	}
}
