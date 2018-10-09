/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.HashMap;
import java.util.Map;

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
