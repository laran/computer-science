/* (C) Copyright 2017-2018 Laran Evans */
package com.laranevans.cs.algorithms.graphs;

import com.laranevans.cs.structures.graphs.Graph;
import com.laranevans.cs.structures.graphs.GraphException;
import com.laranevans.cs.structures.graphs.GraphNode;

import java.util.*;

/**
 * Implementation of Djikstra's algorithm.
 *
 * Use it like this:
 * ------
 *  - Setup
 *  - ---
 *  - construct a Graph g
 *  - String startingNodeId = &lt;string&gt;
 *  - String endingNodeId = &lt;string&gt;
 *  -
 *  - Analyze the graph
 *  - ---
 *  - Topology topology = Djikstra.analyze(g, startingNodeId)
 *  -
 *  - Determine the shortest route
 *  - ---
 *  - Route route = topology.shortestRouteBetween(startingNodeId, endingNodeId)
 *  -
 *  - The shortest route = route.getSteps()
 *  - The distance from startingNodeId to endingNodeId = route.getDistance()
 *
 *  This is more object oriented than most examples of the basic algorithm. I coded
 *  it this way to encapsulate the different aspects of the algorithm in hopes of
 *  making it easier to read and learn from.
 */
public class Djikstra {

	public static String DISTANCE = "distance";

	/**
	 * Analyze every GraphNode to determine it's distance from a given starting GraphNode.
	 *
	 * @param graph
	 * @param startingNodeId
	 * @return a Topology of the whole Graph, with distances from the given starting GraphNode
	 */
	static public Topology analyze(Graph graph, String startingNodeId) {

		Topology topology = new Topology();
		// Initialize the distance to the source to 0
		topology.getShortestDistances().put(startingNodeId, 0);

		// Initialize the Set of unvisited Nodes to all Nodes reachable from initial Node
		// NOTE This should ideally be a PriorityQueue where the highest priority
		// NOTE is the edge with the shortest length. A min-heap could also be used.
		Queue<String> unvisited = new ArrayDeque<>(graph.getNodes().keySet());

		while (!unvisited.isEmpty()) {
			String thisNodeId = unvisited.poll();
			Integer startingDistance = topology.distanceTo(thisNodeId);
			GraphNode thisNode = graph.getNode(thisNodeId);

			for (String thatNodeId : thisNode.getEdges().keySet()) {
				String distance = thisNode.getEdges().get(thatNodeId).getProperties().get(DISTANCE);
				if (Objects.isNull(distance)) {
					throw new GraphException(String.format(
						"GraphEdge from GraphNode with id=\"%s\" to GraphNode with id=\"%s\" has no \"distance\" attribute",
						thisNodeId, thatNodeId));
				}
				topology.ensureShortestRoute(thisNodeId, thatNodeId, startingDistance, Integer.parseInt(distance));
			}
		}

		return topology;
	}

	/**
	 * Class to encapsulate the steps and distance from one GraphNode to another.
	 */
	static public class Route {
		private List<String> steps;
		private Integer distance;

		public Route(List<String> steps, Integer distance) {
			this.steps = steps;
			this.distance = distance;
		}

		public List<String> getSteps() {
			return steps;
		}

		public Integer getDistance() {
			return distance;
		}
	}

	/**
	 * Class to encapsulate all the information recorded when analyzing a Graph for the purpose
	 * of finding the shortest route from one GraphNode to another.
	 */
	static public class Topology {
		private Map<String, Integer> shortestDistances;
		private Map<String, String> routes;

		public Topology() {
			this.shortestDistances = new HashMap<>();
			this.routes = new HashMap<>();
		}

		public Integer distanceTo(String nodeId) {
			Integer distance = shortestDistances.get(nodeId);
			if (Objects.isNull(distance)) {
				distance = Integer.MAX_VALUE;
				shortestDistances.put(nodeId, distance);
			}
			return distance;
		}

		/**
		 * Ensure that we have the shortest route from thisNodeId to thatNodeId.
		 *
		 * @param thisNodeId
		 * @param thatNodeId
		 * @param startingDistance
		 * @param distanceToThat
		 */
		public void ensureShortestRoute(String thisNodeId, String thatNodeId, Integer startingDistance,
		                                Integer distanceToThat) {
			Integer totalDistance = startingDistance + distanceToThat;
			Integer previousShortestDistance = shortestDistances.get(thatNodeId);
			if (Objects.isNull(previousShortestDistance) || totalDistance < previousShortestDistance) {
				shortestDistances.put(thatNodeId, totalDistance);
				routes.put(thatNodeId, thisNodeId);
			}
		}

		public Map<String, Integer> getShortestDistances() {
			return shortestDistances;
		}

		public Map<String, String> getRoutes() {
			return routes;
		}

		public Route shortestRouteBetween(String from, String to) {
			Deque<String> steps = new ArrayDeque<>();

			String nextNode = to;
			while (!nextNode.equals(from)) {
				steps.push(nextNode);
				nextNode = routes.get(nextNode);
			}
			steps.push(from); // add the starting node so the steps is complete

			return new Route(new ArrayList<>(steps), shortestDistances.get(to));
		}
	}
}
