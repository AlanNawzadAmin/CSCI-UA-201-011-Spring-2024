package Recurrsion_final;

public class IntegerArrayList{
	public static int MAX_SIZE = 1000;
	Integer array[];
	int size;
	
	public IntegerArrayList(){
		array = new Integer[MAX_SIZE];
	}
	
	public int size() { return size; }
	public Integer getAtIndex(Integer index) {
		return array[index];
	}
	
	public void addLast(Integer element) {
		array[size] = element;
		size++;
	}
	
	public Integer removeLast() {
		Integer remove = array[size-1];
		array[size-1] = null;
		size--;
		return remove;
	}
	
	public Integer removeFirst() {
		Integer remove = array[0];
		for (int i=0; i<size; i++) {
			array[i] = array[i+1];
		}
		size--;
		return remove;
	}

	public void addFirst(Integer element) {
		for (int i=size; i>0; i--) {
			array[i] = array[i-1];
		}
		array[0] = element;
		size++;
	}
	
	public boolean search(Integer element, int low, int high){
		if (low > high) return false;
		else if (array[low] == element) return true;
		else return search(element, low+1, high);
	}
	
	public boolean binarySearch(int element, int low, int high){
//		assumes list is sorted
		if (low > high) return false;
		else{
			int mid = (low + high) / 2;
			if (element == array[mid]) return true;
			else if (element < array[mid]) {
				return binarySearch(element, low, mid-1);}
			else {
				return binarySearch(element, mid+1, high);
			}
		}
	}
	
	public static void main(String [] args) {
		IntegerArrayList list = new IntegerArrayList();
		list.addLast(1);
		list.addLast(27);
		list.addLast(39);
		System.out.println(list.getAtIndex(1));
		System.out.println(list.search(27, 0, list.size()-1));
		System.out.println(list.binarySearch(39, 0, list.size()-1));
	}
}
