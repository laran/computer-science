/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {

	private String id;
	private Map<String, String> properties;
	private Map<String, GraphEdge> edges;

	public GraphNode(String id) {
		this(id, new HashMap<>());
	}

	public GraphNode(String id, Map<String, String> properties) {
		this(id, properties, new HashMap<>());
	}

	public GraphNode(String id, Map<String, String> properties, Map<String, GraphEdge> edges) {
		this.id = id;
		this.properties = properties;
		this.edges = edges;
	}

	public boolean isConnectedTo(GraphNode node) {
		return this.isConnectedTo(node.id);
	}

	public boolean isConnectedTo(String nodeId) {
		return this.edges.containsKey(nodeId);
	}

	public GraphNode addDirectedEdgeTo(GraphNode node) {
		return addDirectedEdgeTo(node, new HashMap<>());
	}

	public GraphNode addDirectedEdgesTo(GraphNode... nodes) {
		for (GraphNode node : nodes) {
			addDirectedEdgeTo(node);
		}
		return this;
	}

	public synchronized GraphNode addDirectedEdgeTo(GraphNode node, Map<String, String> properties) {
		if (!this.edges.containsKey(node.getId())) {
			this.edges.put(node.id, new GraphEdge(properties));
		}
		return this;
	}

	public synchronized GraphNode removeDirectedEdgeTo(GraphNode node) {
		this.edges.remove(node.id);
		return this;
	}

	public GraphNode addUndirectedEdgeTo(GraphNode node) {
		return addUndirectedEdgeTo(node, new HashMap<>());
	}

	public GraphNode addUndirectedEdgesTo(GraphNode... nodes) {
		for (GraphNode node : nodes) {
			addUndirectedEdgeTo(node);
		}
		return this;
	}

	public synchronized GraphNode addUndirectedEdgeTo(GraphNode node, Map<String, String> properties) {
		synchronized (node) {
			// Have both nodes share the SAME edge so that changes to edge properties are
			// visible from both Nodes.

			GraphEdge edge = null;

			// Don't overwrite an edge that already exists.

			if (!this.edges.containsKey(node.getId())) {
				if (node.edges.containsKey(this.id)) {
					// an edge exists from node -> this but not from this -> node
					edge = node.getEdges().get(this.id);
					this.edges.put(node.getId(), edge);
				}
			} else if (!node.edges.containsKey(this.id)) {
				// an edge exists from this -> node but not from node -> this
				edge = this.edges.get(node.getId());
				node.edges.put(this.id, edge);
			}

			if (edge == null) {
				edge = new GraphEdge(properties);
				this.edges.put(node.id, edge);
				node.edges.put(this.id, edge);
			} else {
				edge.setProperties(properties);
			}
		}

		return this;
	}

	synchronized public void removeUndirectedEdgeTo(GraphNode node) {
		synchronized (node) {
			this.edges.remove(node.getId());
			node.edges.remove(this.getId());
		}
	}

	public String getId() {
		return id;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public Map<String, GraphEdge> getEdges() {
		return edges;
	}

	@Override
	public String toString() {
		return "GraphNode{" +
			"id='" + id + '\'' +
			", properties=" + properties +
			", edges=" + edges +
			'}';
	}
}
