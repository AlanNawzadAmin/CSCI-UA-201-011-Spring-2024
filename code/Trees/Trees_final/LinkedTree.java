package Trees_final;
import LinkedList_final.DoublyLinkedList;
import LinkedList_final.GoodList;
import StackQueues_final.Stack;
import StackQueues_final.LinkedStack;
import StackQueues_final.Queue;
import StackQueues_final.LinkedQueue;

public class LinkedTree<E> implements Tree<E>{
	private class Node implements Position<E>{
		private E element;
		private DoublyLinkedList<Position<E>> children;
		private Node parent;
		
		public Node(E element, Node parent) {
			this.element = element;
			this.parent = parent;
			this.children = new DoublyLinkedList<Position<E>>();
		}
		
		public E getElement(){return element;}
		public Node getParent() {return parent;}
		public GoodList<Position<E>> getChildren() {return children;}
	}
	
	Node root;
	int size;

	public LinkedTree(E root_element) {
		root = new Node(root_element, null);
	}
	
	public Position<E> root(){
		return root;
	}
	public Position<E> parent(Position<E> p){
		return ((Node)p).getParent();
	};
	public GoodList< Position<E> >  children(Position<E> p){
		return ((Node)p).getChildren();
	};
	public int numChildren(Position<E> p) {
		return ((Node)p).getChildren().size();
	}
	public boolean isInternal(Position<E> p) {
		return numChildren(p) != 0;
	}
	public boolean isExternal(Position<E> p) {
		return !isInternal(p);
	}
	public boolean isRoot(Position<E> p) {
		return p == root;
	}
	public int size() {return size;}
	public boolean isEmpty() { return size == 0;}
	
	public int depth(Position<E> p) {
		if (isRoot(p)) return 0;
		else return 1 + depth(parent(p));
	}
	
	public int height(Position<E> p) {
		int h = 0;
		GoodList< Position<E> > ch = children(p);
		for (int i=0;i< ch.size(); i++) {
			h = Math.max(h, height(ch.getAtIndex(i)));
		}
		return h;
	}
	
//	Using recursion
	private GoodList<Position<E>> inOrderTraversal(Position<E> p, GoodList<Position<E>> list){
		list.addLast(p);
		GoodList<Position<E>> children = children(p);
		for (int i=0; i<children.size(); i++) {
			inOrderTraversal(children.getAtIndex(i), list);
		}
		return list;
	}
	
	private GoodList<Position<E>> inOrderTraversal(Position<E> p){
		GoodList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		return inOrderTraversal(p, list);
	}
	
//	Using stacks
	private GoodList<Position<E>> positions(Position<E> p){
		GoodList<Position<E>> pos = new DoublyLinkedList<Position<E>>();
		Stack<Position<E>> stack = new LinkedStack<Position<E>>();
		stack.push(p);
		while (stack.size() > 0) {
			Position<E> next_pos = stack.pop();
			pos.addLast(next_pos);
			GoodList<Position<E>> ch = children(next_pos);
			for (int j=0; j<ch.size(); j++) {
				stack.push(ch.getAtIndex(j));
			}
		}
		return pos;
	}
	
	private boolean breadthFirstSearch(E element){
		Stack<Position<E>> stack = new LinkedStack<Position<E>>();
		stack.push(root);
		while (stack.size() > 0) {
			Position<E> next_pos = stack.pop();
			if (next_pos.getElement() == element) return true;
			GoodList<Position<E>> ch = children(next_pos);
			for (int j=0; j<ch.size(); j++) {
				stack.push(ch.getAtIndex(j));
			}
		}
		return false;
	}
	
	private boolean depthFirstSearch(E element){
		Queue<Position<E>> queue = new LinkedQueue<Position<E>>();
		queue.enqueue(root);
		while (queue.size() > 0) {
			Position<E> next_pos = queue.dequeue();
			if (next_pos.getElement() == element) return true;
			GoodList<Position<E>> ch = children(next_pos);
			for (int j=0; j<ch.size(); j++) {
				queue.enqueue(ch.getAtIndex(j));
			}
		}
		return false;
	}
	
	public GoodList<Position<E>> positions(){
		return positions(root);
	}
}
