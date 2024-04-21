package Graphs_final;

import LinkedList_final.GoodList;
import Maps_final.Map;
import Maps_final.UnsortedMap;
import java.lang.Math;


public class Dijkstra {
	public static <V> Map<Vertex<V>, Double> dijkstraTraversal(Graph<V, Double> graph, Vertex<V> start){
		adaptivePriorityQueue<Vertex<V>> pq = new HeapPQ<Vertex<V>>();
		Map<Vertex<V>, Object> seen = new UnsortedMap<Vertex<V>, Object>();
		Map<Vertex<V>, Double> minDists = new UnsortedMap<Vertex<V>, Double>();
		Map<Vertex<V>, Object> pqlocs = new UnsortedMap<Vertex<V>, Object>();
		pq.put(0, start);
		while (pq.size() > 0) {
			Vertex<V> curr_pos = pq.removeMin();
			seen.put(curr_pos, 0);
			GoodList<Edge<Double>> ch = graph.outgoingEdges(curr_pos);
			for (int j=0; j<ch.size(); j++) {
				Edge<Double> next_edge = ch.getAtIndex(j);
				Vertex<V> next_vertex = next_edge.getEndpoints()[1];
				if (seen.get(next_vertex) == null) {
//					get new minimum distance
					Double min_dist = minDists.get(curr_pos) + next_edge.getElement();
					Double old_min_dist = minDists.get(next_vertex);
					if (old_min_dist != null) {
						min_dist = Math.min(minDists.get(next_vertex), min_dist);
					}
					minDists.put(next_vertex, min_dist);
//					update pq
					Object pq_loc = pqlocs.get(next_vertex);
					if (pq_loc == null) {
						pq.put(min_dist, next_vertex);
					} else {
						pq.replaceKey(pq_loc, min_dist);
					}
				}
			}
		}
		return minDists;
	}
}
