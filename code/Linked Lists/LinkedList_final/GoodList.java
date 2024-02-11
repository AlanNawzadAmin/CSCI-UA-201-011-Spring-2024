package LinkedList_final;

public interface GoodList<E> {
	public abstract int size();
	public abstract void addFirst(E element);
	public abstract void addLast(E element);
	public abstract E removeFirst();
	public abstract E removeLast();
	public abstract E getAtIndex(int Index);
	
//	public abstract void reverseOrder();
//	public abstract void sort();
//	public abstract boolean search(E);
//	public abstract GoodList<E> getSlice(int start, int end);
}