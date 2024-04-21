package Graphs_final;

import LinkedList_final.ArrayList;
import LinkedList_final.GoodList;
import Maps_final.Map;
import Maps_final.UnsortedMap;
import StackQueues_final.LinkedStack;
import StackQueues_final.Stack;

public class topoOrdering {
	public static <V, E> GoodList<Vertex<V>> topo(Graph<V, E> graph){
		Map<Vertex<V>, Integer> nParents = new UnsortedMap<Vertex<V>, Integer>();
		Map<Vertex<V>, Object> seen = new UnsortedMap<Vertex<V>, Object>();
		Stack<Vertex<V>> stack = new LinkedStack<Vertex<V>>();
		GoodList<Vertex<V>> topoOrder = new ArrayList<Vertex<V>>();
		GoodList<Vertex<V>> vertices = graph.vertices();
		for (int i=0; i<vertices.size(); i++) {
			Vertex<V> vertex = vertices.getAtIndex(i);
			int indeg = graph.inDegree(vertex);
			nParents.put(vertex, indeg);
			if (indeg == 0) {
				stack.push(vertex);
				seen.put(vertex, 0);
			}
		}
		while (stack.size()>0) {
			Vertex<V> vertex = stack.pop();
			topoOrder.addLast(vertex);
			GoodList<Edge<E>> ch = graph.outgoingEdges(vertex);
			for (int j=0; j<ch.size(); j++) {
				Edge<E> next_edge = ch.getAtIndex(j);
				Vertex<V> next_vertex = next_edge.getEndpoints()[1];
				if (seen.put(vertex, 0) == null) {
					int n_parents = nParents.get(next_vertex)-1;
					nParents.put(next_vertex, n_parents);
					if (n_parents == 0) {
						stack.push(next_vertex);
					}
				}
			}
		}
		return topoOrder;
	}
}
