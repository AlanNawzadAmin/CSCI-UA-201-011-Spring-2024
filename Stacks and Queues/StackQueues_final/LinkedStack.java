package StackQueues_final;
import LinkedList_final.LinkedList;

public class LinkedStack<E> extends LinkedList<E> implements Stack<E>{
	private LinkedList<E> list;
	
	public LinkedStack(){
		list = new LinkedList<E>();
	}
	
	public E pop() {
		return list.removeFirst();
	}
	public void push(E element) {
		list.addFirst(element);
	}
	
	public static void main(String [] args) {
		LinkedStack<Integer> stack = new LinkedStack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
