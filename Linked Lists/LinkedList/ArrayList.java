package LinkedList;

public class ArrayList<E> implements GoodList<E>{
	public static int MAX_SIZE = 1000;
	E array[];
	int size;
	
	public ArrayList()
	
	public int size()
	
	public E getAtIndex(int index)
	
	public void addLast(E element)
	
	public E removeLast()
	
	public E removeFirst()

	public void addFirst(E element)
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList();
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);
		System.out.println(list.getAtIndex(1));
	}
}
