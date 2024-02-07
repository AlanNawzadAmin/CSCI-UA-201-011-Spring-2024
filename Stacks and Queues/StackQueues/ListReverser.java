package StackQueues;

public class ListReverser{
	public static <E> void reverse(E[] array) {
		Stack<E> stack = new LinkedStack<E>();
		for (int i=0; i<array.length; i++) {
			stack.push(array[i]);
		}
		for (int i=0; i<array.length; i++) {
			array[i] = stack.pop();
		}
	}
	public static void main(String[] args) {
		Integer[] array = new Integer[20];
		for (int i=0; i<array.length; i++) {
			array[i] = i;
		}
		ListReverser.<Integer>reverse(array);
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
