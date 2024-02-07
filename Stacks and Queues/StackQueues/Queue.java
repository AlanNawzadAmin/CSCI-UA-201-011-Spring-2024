package StackQueues;

public interface Queue<E> {
	public abstract E enqueue();
	public abstract E dequeue();
	public abstract int size();
}
