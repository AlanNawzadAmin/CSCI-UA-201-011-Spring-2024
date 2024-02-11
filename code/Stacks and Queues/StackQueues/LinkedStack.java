package StackQueues;
import LinkedList_final.LinkedList;

public class LinkedStack<E> extends LinkedList<E> implements Stack<E>{	
	
	public void push(E element) {this.addFirst(element);}
	public E pop() {return this.removeFirst();}
	
	
	
	
	public static void main(String [] args) {
		Stack<Integer> stack = new LinkedStack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(4);
		System.out.println(stack.pop());
	}
}
