package Graphs;

public interface adaptivePriorityQueue<E> {
	int size();
	E removeMin();
	Object put(double priority, E element);
	void replaceKey(Object u, double key);
}
