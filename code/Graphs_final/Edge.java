package Graphs_final;

public interface Edge<E> {
	Vertex[] getEndpoints();
	E getElement();
}
