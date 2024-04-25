package Graphs;
import Graphs_final.Edge;
import Graphs_final.Vertex;
import LinkedList_final.ArrayList;
import LinkedList_final.GoodList;
import Maps_final.Map;
import Maps_final.UnsortedMap;
import StackQueues_final.LinkedStack;
import StackQueues_final.Stack;
import StackQueues_final.LinkedQueue;
import StackQueues_final.Queue;

public class EdgeListGraph<V, E>{
	private class InnerVertex<V> implements Vertex<V>{
		V element;
		InnerVertex(V element){
			this.element = element;
		}
		public V getElement() {
			return element;
		}
	}
	
	private class InnerEdge<E> implements Edge<E>{
		E element;
		InnerVertex<V> endpoints[];
		InnerEdge(Vertex<V> from, Vertex<V> to, E element){
			this.element = element;
			endpoints = (InnerVertex<V>[])(new Object[]{from, to});
		}
		public E getElement() {
			return element;
		}
		public Vertex<V>[] getEndpoints() {
			return endpoints;
		}
	}
	
	ArrayList<Vertex<V>> vertices;
	ArrayList<Edge<E>> edges;
	int n_vertices;
	int n_edges;
	
	GoodList<Vertex<V>> vertices(){
		return vertices;
	}

	GoodList<Edge<E>> edges(){
		return edges;
	}
	
	GoodList<Edge<E>> outgoingEdges(Vertex<V> v){
		ArrayList<Edge<E>> outgoing = new ArrayList<Edge<E>>();
		for(int i=0; i< n_edges;i++) {
			Edge<E> edge = edges.getAtIndex(i); 
			if(v == edge.getEndpoints()[0]) {
				outgoing.addLast(edge);
			}
		}
		return outgoing;
	}
	
	GoodList<Edge<E>> incomingEdges(Vertex<V> v){
		ArrayList<Edge<E>> incoming = new ArrayList<Edge<E>>();
		for(int i=0; i< n_edges;i++) {
			Edge<E> edge = edges.getAtIndex(i); 
			if(v == edge.getEndpoints()[1]) {
				incoming.addLast(edge);
			}
		}
		return incoming;
	}
	
	Edge<E> getEdge(Vertex<V> from, Vertex<V> to){
		for(int i=0; i< n_edges;i++) {
			Edge<E> edge = edges.getAtIndex(i); 
			if(from == edge.getEndpoints()[0] && to == edge.getEndpoints()[1]) {
				return edge;
			}
		}
		return null;
	}
	
	Vertex<V>[] endVertices(Edge<E> e){
		return e.getEndpoints();
	}
	
	Vertex<V> opposite(Vertex<V> v, Edge<E> e){
		Vertex<V>[] endpoints = e.getEndpoints();
		if(v == endpoints[0]) {
			return endpoints[1];
		} else if (v == endpoints[1]) {
			return endpoints[0];
		} else {
			return null;
		}
	}
	
	void insertVertex(V x) {
		vertices.addLast(new InnerVertex<V>(x));
		n_vertices++;
	}
	
	void insertEdge(Vertex<V> from, Vertex<V> to, E x){
		edges.addLast(new InnerEdge<E>(from, to, x));
		n_edges++;
	}
	
	void removeEdge(Edge<E> e){
//		Can be made more efficient with a position list
		for(int i=0; i<n_edges; i++) {
			if(edges.getAtIndex(i) == e) {
				edges.removeAtIndex(i);
			}
		}
		n_edges--;
	}
	
	void removeVertex(Vertex<V> v) {
		GoodList<Edge<E>> outgoing = outgoingEdges(v);
		GoodList<Edge<E>> incoming = incomingEdges(v);
		for(int i=0; i<outgoing.size(); i++) {
			removeEdge(outgoing.getAtIndex(i));
		}
		for(int i=0; i<incoming.size(); i++) {
			removeEdge(incoming.getAtIndex(i));
		}
//		Can be made more efficient with a position list
		for(int i=0; i<n_vertices; i++) {
			if(vertices.getAtIndex(i) == v) {
				vertices.removeAtIndex(i);
			}
		}
		n_vertices--;
	}
	
	int numVertices() {
		return n_vertices;
	}
	int numEdges() {
		return n_edges;
	}
	int outDegree(Vertex<V> v) {
		return outgoingEdges(v).size();
	}
	int inDegree(Vertex<V> v){
		return incomingEdges(v).size();
	}
	
	private boolean depthFirstSearch(Vertex<V> end, Vertex<V> start){
		Stack<Vertex<V>> stack = new LinkedStack<Vertex<V>>();
		Map<Vertex<V>, Object> seen = new UnsortedMap<Vertex<V>, Object>();
		stack.push(start);
		seen.put(start, 0);
		while (stack.size() > 0) {
			Vertex<V> next_pos = stack.pop();
			if (next_pos == end) return true;
			GoodList<Edge<E>> ch = outgoingEdges(next_pos);
			for (int j=0; j<ch.size(); j++) {
				Vertex<V> next_vertex = ch.getAtIndex(j).getEndpoints()[1];
				if (seen.put(next_vertex, 0) == null) {
					stack.push(next_vertex);
				}
			}
			GoodList<Edge<E>> chi = incomingEdges(next_pos);
			for (int j=0; j<chi.size(); j++) {
				Vertex<V> next_vertex = chi.getAtIndex(j).getEndpoints()[0];
				if (seen.put(next_vertex, 0) == null) {
					stack.push(next_vertex);
				}
			}
		}
		return false;
	}
	
	private GoodList<Edge<E>> newListPlusOne(GoodList<Edge<E>> list, Edge<E> newEdge) {
//		copy list
		GoodList<Edge<E>> newList = new ArrayList<Edge<E>>();
		for (int j=0; j<list.size(); j++) {
			newList.addLast(list.getAtIndex(j));
		}
//		add next element
		newList.addLast(newEdge);
		return newList;
	}
	
	private GoodList<Edge<E>> breadthFirstSearch(Vertex<V> end, Vertex<V> start){
		Queue<Object[]> queue = new LinkedQueue<Object[]>();
		queue.enqueue(new Object[] {start, new ArrayList<Edge<E>>()});
		
		Map<Vertex<V>, Object> seen = new UnsortedMap<Vertex<V>, Object>();
		seen.put(start, 0);
		while (queue.size() > 0) {
//			dequeue and unpack
			Object[] posAndPath = queue.dequeue();
			Vertex<V> next_pos = (Vertex<V>)(posAndPath[0]);
			GoodList<Edge<E>> nextPath = (GoodList<Edge<E>>)(posAndPath[1]);
//			check element
			if (next_pos == end) return nextPath;
//			iterate through unseen neighbors
			GoodList<Edge<E>> ch = outgoingEdges(next_pos);
			for (int j=0; j<ch.size(); j++) {
				Edge<E> next_edge = ch.getAtIndex(j);
				Vertex<V> next_vertex = next_edge.getEndpoints()[1];
				if (seen.put(next_vertex, 0) == null) {
					GoodList<Edge<E>> new_path = newListPlusOne(nextPath, next_edge);
					queue.enqueue(new Object[] {next_vertex, new_path});
				}
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
