package Graphs_final;
import LinkedList_final.GoodList;
import LinkedList_final.ArrayList;

public class EdgeListGraph<V, E> {
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
//		May include nulls
		return vertices;
	}

	GoodList<Edge<E>> edges(){
//		May include nulls
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
		} else {
			return endpoints[0];
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
	}
	
	void removeEdge(Edge<E> e){
//		Can be made more efficient with a position list
		for(int i=0; i<n_edges; i++) {
			if(edges.getAtIndex(i) == e) {
				edges.removeAtIndex(i);
			}
		}
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
	
}
