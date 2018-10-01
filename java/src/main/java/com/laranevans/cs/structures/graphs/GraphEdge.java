/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs;

import java.util.HashMap;
import java.util.Map;

public class GraphEdge {
	private Map<String, String> properties;

	public GraphEdge() {
		this(new HashMap<>());
	}

	public GraphEdge(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, String> getProperties() {
		return properties;
	}
}
