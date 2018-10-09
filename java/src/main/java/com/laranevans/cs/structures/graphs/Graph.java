/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * A graph as an adjacency list backed by a map.
 * <p>
 * I chose an adjacency list instead of an edge list or an adjacency matrix for these reasons:
 * - An edge list maintains a global state whereas an adjacency list maintains local state.
 * Local state scales better.
 * - An adjacency matrix isn't as flexible. It requires a global state and for all nodes to have
 * integer ids (instead of strings) and for the graph to have a fixed-size.
 * <p>
 * So, an adjacency list is more flexible and more scalable, which is why I chose it.
 */
public class Graph {
	private Map<String, GraphNode> nodes;

	public Graph() {
		this(new HashMap<>());
	}

	public Graph(Map<String, GraphNode> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Add the GraphNode, throwing a GraphException if it's already present.
	 *
	 * @param node
	 * @return
	 */
	public Graph addNode(GraphNode node) {
		if (nodes.containsKey(node.getId())) {
			throw new GraphException(
				String.format(
					"Graph already contains a GraphNode with id='%s' ", node.getId()));
		}

		nodes.put(node.getId(), node);
		return this;
	}

	public Graph removeNode(GraphNode node) {
		nodes.remove(node.getId());
		return this;
	}

	public Graph addAll(GraphNode... nodes) {
		for (GraphNode node : nodes) {
			this.addNode(node);
		}
		return this;
	}

	public GraphNode getNode(String id) {
		return this.nodes.get(id);
	}

	/**
	 * Insert the GraphNode, overwriting it if it's already there.
	 *
	 * @param node
	 * @return
	 */
	public Graph setNode(GraphNode node) {
		nodes.put(node.getId(), node);
		return this;
	}

	public Map<String, GraphNode> getNodes() {
		return nodes;
	}

	/**
	 * Convenience method to get all Edges.
	 *
	 * @return
	 */
	public Map<String, Map<String, GraphEdge>> getEdges() {
		Map<String, Map<String, GraphEdge>> edges = new HashMap<>();
		for (String nodeId : this.getNodes().keySet()) {
			edges.put(nodeId, getNode(nodeId).getEdges());
		}
		return edges;
	}

	@Override
	public String toString() {
		return "Graph{" +
			"nodes=" + nodes +
			'}';
	}
}
