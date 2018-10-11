/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.structures.graphs.algorithms;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphEdge;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.*;

/**
 * Use Prim's algorithm to find a minimum spanning tree on a weighted, undirected graph.
 */
public class Prims {

	public static String DISTANCE = "distance";

	// Returns a NEW Graph, which represents the minimum spanning tree.
	public static Graph of(Graph graph) {
		Graph mst = new Graph();

		// Iterate all Nodes in the Graph starting at a random Node.
		// No need to track which nodes have been visited because this will visit each Node exactly once.
		graph.getNodes().keySet().stream().forEach(nodeId -> {

			GraphNode graphNode = graph.getNode(nodeId);

			// Because the Graph is undirected, this will find edges in both directions.
			// But we need to check that there is at least one edge to the Node.
			if (!graphNode.getEdges().isEmpty()) {

				// Find the node with the minimum distance value.
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

				// Ensure that both nodes are added to the MST.
				// (Remember that all Nodes are added to the MST, but not all Edges)
				GraphNode mstNode = mst.getNode(nodeId);
				if (mstNode == null) {
					mstNode = new GraphNode(nodeId);
					mst.addNode(mstNode);
				}

				GraphNode mstNeighborNode = mst.getNode(nearestNeighborId);
				if (mstNeighborNode == null) {
					mstNeighborNode = new GraphNode(nearestNeighborId);
					mst.addNode(mstNeighborNode);
				}

				Map<String, String> props = new HashMap<>();
				props.put(DISTANCE, "" + minDistance);
				mstNode.addUndirectedEdgeTo(mstNeighborNode, props);
			}
		});

		return mst;
	}
}
