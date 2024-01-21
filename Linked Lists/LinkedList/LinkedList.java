package LinkedList;

// Adapted from Goodrich textbook
public class LinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			element = e; next = n;
		}
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public LinkedList() { }
	
//	Accessors
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
//	Adding and removing
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty( ))
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst( ) {
		if (isEmpty( ))
			return null;
		E answer = head.getElement( );
		head = head.getNext( );
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}
	
	public E getAtIndex(int index)
	
//	public E removeLast()
	
	public static void main(String [] args) {
		LinkedList<Integer> list = new LinkedList();
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);
		System.out.println(list.getAtIndex(0));
	}
}