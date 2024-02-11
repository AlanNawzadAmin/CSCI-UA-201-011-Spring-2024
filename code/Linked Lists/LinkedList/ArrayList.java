package LinkedList;

public class ArrayList<E> implements GoodList<E>{
	public static int MAX_SIZE = 1000;
	E array[];
	int size;
	
	public ArrayList(){
		array = (E[ ]) new Object[MAX_SIZE];
	}
	
	public int size() { return size; }
	public E getAtIndex(int index) {
		return array[index];
	}
	
	public void addLast(E element) {
		array[size] = element;
		size++;
	}
	
	public E removeLast() {
		E remove = array[size-1];
		array[size-1] = null;
		size--;
		return remove;
	}
	
	public E removeFirst() {
		E remove = array[0];
		for (int i=0; i<size; i++) {
			array[i] = array[i+1];
		}
		size--;
		return remove;
	}

	public void addFirst(E element) {
		for (int i=size; i>0; i--) {
			array[i] = array[i-1];
		}
		array[0] = element;
		size++;
	}
	
	public boolean search(E element){
		for (int i=0; i<size; i++) {
			if (getAtIndex(i) == element) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList();
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);
		System.out.println(list.getAtIndex(1));
	}
}
