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
}
