/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphEdge;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.*;

/**
 * Prim's algorithm finds a minimum spanning tree on a weighted, directed graph.
 */
public class Prims {

	public static String DISTANCE = "distance";

	// Returns a NEW Graph, which represents the minimum spanning tree.
	public static Graph of(Graph graph) {
		Graph mst = new Graph();

		Set<String> visited = new HashSet<>();

		for (String nodeId : graph.getNodes().keySet()) {
			visited.add(nodeId);

			GraphNode graphNode = graph.getNode(nodeId);
			if (!graphNode.getEdges().isEmpty()) {
				String nearestNeighborId = null;
				Integer minDistance = Integer.MAX_VALUE;
				for (String connectedNodeId : graphNode.getEdges().keySet()) {
					GraphEdge edge = graphNode.getEdges().get(connectedNodeId);
					Integer distance = Integer.parseInt(edge.getProperties().get(DISTANCE));
					if (distance < minDistance) {
						minDistance = distance;
						nearestNeighborId = connectedNodeId;
					}
				}

				GraphNode mstNode = mst.getNode(nodeId);
				if (Objects.isNull(mstNode)) {
					mstNode = new GraphNode(nodeId);
					mst.addNode(mstNode);
				}

				GraphNode mstNeighborNode = mst.getNode(nearestNeighborId);
				if (Objects.isNull(mstNeighborNode)) {
					mstNeighborNode = new GraphNode(nearestNeighborId);
					mst.addNode(mstNeighborNode);
				}

				Map<String, String> props = new HashMap<>();
				props.put(DISTANCE, "" + minDistance);
				mstNode.addUndirectedEdgeTo(mstNeighborNode, props);
			}
		}

		return mst;
	}
}
