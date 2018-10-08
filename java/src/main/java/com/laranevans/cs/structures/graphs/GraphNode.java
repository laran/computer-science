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

	public GraphNode addDirectedEdgeTo(GraphNode node, Map<String, String> properties) {
		this.edges.put(node.id, new GraphEdge(properties));
		return this;
	}

	public GraphNode removeDirectedEdgeTo(GraphNode node) {
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

	public GraphNode addUndirectedEdgeTo(GraphNode node, Map<String, String> properties) {
		this.edges.put(node.id, new GraphEdge(properties));
		node.edges.put(this.id, new GraphEdge(properties));
		return this;
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
