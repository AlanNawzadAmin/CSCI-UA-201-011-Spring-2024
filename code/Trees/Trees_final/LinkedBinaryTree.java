package Trees_final;

import LinkedList_final.DoublyLinkedList;
import LinkedList_final.GoodList;
import StackQueues_final.LinkedQueue;
import StackQueues_final.LinkedStack;
import StackQueues_final.Queue;
import StackQueues_final.Stack;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
	private class Node implements Position<E>{
		private E element;
		private Position<E> left;
		private Position<E> right;
		private Node parent;
		
		public Node(E element, Node parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public E getElement(){return element;}
		public Node getParent() {return parent;}
		public Position<E> getLeft() {return left;}
		public Position<E> getRight() {return right;}
	}
	
	Node root;
	int size;

	public LinkedBinaryTree(E root_element) {
		root = new Node(root_element, null);
	}
	
	public Position<E> root(){
		return root;
	}
	public Position<E> parent(Position<E> p){
		return ((Node)p).getParent();
	};
	public GoodList< Position<E> >  children(Position<E> p){
		GoodList< Position<E> > list = new DoublyLinkedList< Position<E> >();
		if (((Node)p).getLeft() != null) list.addLast(((Node)p).getLeft());
		if (((Node)p).getRight() != null) list.addLast(((Node)p).getRight());
		return list;
	}
	public Position<E> left(Position<E> p){
		return ((Node) p).getLeft();
	}
	public Position<E> right(Position<E> p){
		return ((Node) p).getRight();
	}
	public int numChildren(Position<E> p) {
		return children(p).size();
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
		if (p == null) return -1;
		int h = Math.max(height(((Node)p).getRight()),
				         height(((Node)p).getLeft())) + 1;
		return h;
	}
	
//	Using recursion
	private GoodList<Position<E>> preorderPositions(Position<E> p, GoodList<Position<E>> list){
		if (p == null) return list;
		list.addLast(p);
		preorderPositions(((Node)p).getLeft(), list);
		preorderPositions(((Node)p).getRight(), list);
		return list;
	}
	
	private GoodList<Position<E>> preorderPositions(Position<E> p){
		GoodList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		return preorderPositions(p, list);
	}
	
	private GoodList<Position<E>> postorderPositions(Position<E> p, GoodList<Position<E>> list){
		if (p == null) return list;
		postorderPositions(((Node)p).getLeft(), list);
		postorderPositions(((Node)p).getRight(), list);
		list.addLast(p);
		return list;
	}
	
	private GoodList<Position<E>> postorderPositions(Position<E> p){
		GoodList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		return postorderPositions(p, list);
	}
	
	private GoodList<Position<E>> inorderPositions(Position<E> p, GoodList<Position<E>> list){
		if (p == null) return list;
		inorderPositions(((Node)p).getLeft(), list);
		list.addLast(p);
		inorderPositions(((Node)p).getRight(), list);
		return list;
	}
	
	private GoodList<Position<E>> inorderPositions(Position<E> p){
		GoodList<Position<E>> list = new DoublyLinkedList<Position<E>>();
		return inorderPositions(p, list);
	}
	
	public GoodList<Position<E>> positions(){
		return preorderPositions(root);
	}
}

