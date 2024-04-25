package Graphs;

import Graphs_final.Edge;
import Graphs_final.Graph;
import Graphs_final.HeapPQ;
import Graphs_final.Vertex;
import Graphs_final.adaptivePriorityQueue;
import LinkedList_final.GoodList;
import Maps_final.Map;
import Maps_final.UnsortedMap;

public class Dijkstra {
	public static <V> Map<Vertex<V>, Double> dijkstraTraversal(Graph<V, Double> graph, Vertex<V> start){
		adaptivePriorityQueue<Vertex<V>> pq = new HeapPQ<Vertex<V>>();
		Map<Vertex<V>, Object> seen = new UnsortedMap<Vertex<V>, Object>();
		Map<Vertex<V>, Double> minDists = new UnsortedMap<Vertex<V>, Double>();
		Map<Vertex<V>, Object> pqlocs = new UnsortedMap<Vertex<V>, Object>();
		pq.put(0, start);
		seen.put(start,  0);
		while (pq.size() > 0) {
			Vertex<V> curr_pos = pq.removeMin();
			seen.put(curr_pos, 0);
			GoodList<Edge<Double>> ch = graph.outgoingEdges(curr_pos);
			for (int j=0; j<ch.size(); j++) {
				Edge<Double> next_edge = ch.getAtIndex(j);
				Vertex<V> next_vertex = next_edge.getEndpoints()[1];
				
//				get new minimum distance
				Double new_min_dist = minDists.get(curr_pos) + next_edge.getElement();
				Double old_min_dist = minDists.get(next_vertex);
				if (old_min_dist != null) {
					new_min_dist = Math.min(old_min_dist, new_min_dist);
				}
				minDists.put(next_vertex, new_min_dist);
//				update pq
				Object pq_loc = pqlocs.get(next_vertex);
				if (pq_loc == null) {
					Object new_loc = pq.put(new_min_dist, next_vertex); // if next_vertex not in pq
					pqlocs.put(next_vertex, new_loc);
				} else {
					pq.replaceKey(pq_loc, new_min_dist);
				}
			}
		}
		return minDists;
	}
}
