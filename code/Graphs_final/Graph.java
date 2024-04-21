package Graphs_final;
import LinkedList_final.GoodList;

public interface Graph<V, E> {
	GoodList<Vertex<V>> vertices();
	GoodList<Edge<E>> edges();
	
	GoodList<Edge<E>> outgoingEdges(Vertex<V> v);
	GoodList<Edge<E>> incomingEdges(Vertex<V> v);
	
	Edge<E> getEdge(Vertex<V> from, Vertex<V> to);
	Vertex<V>[] endVertices(Edge<E> e);
	Vertex<V> opposite(Vertex<V> v, Edge<E> e);

	void insertVertex(V x);
	void insertEdge(Vertex<V> from, Vertex<V> to, E x);
	void removeVertex(Vertex<V> v);
	void removeEdge(Edge<E> e);
		
	int numVertices();
	int numEdges();
	int outDegree(Vertex<V> v);
	int inDegree(Vertex<V> v);
}
