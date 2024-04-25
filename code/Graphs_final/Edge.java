package Graphs;

public interface Edge<E> {
	E getElement();
	Vertex[] getEndpoints();
}
