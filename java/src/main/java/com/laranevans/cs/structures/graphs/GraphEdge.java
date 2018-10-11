/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphEdge {
	private Map<String, String> properties;

	public GraphEdge() {
		this(new HashMap<>());
	}

	public GraphEdge(Map<String, String> properties) {
		setProperties(properties);
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	protected void setProperties(Map<String, String> properties) {
		// Synchronize on the map to support updates in undirected graphs (where the edge
		// can be updated by either node)
		if (properties == null) {
			this.properties = null;
		} else {
			this.properties = properties;
		}
	}

	@Override
	public String toString() {
		return "GraphEdge{" +
			"properties=" + properties.keySet().stream()
			.map(k -> String.format("%s=%s", k, properties.get(k))).collect(Collectors.joining(", "))
			+
			'}';
	}
}
