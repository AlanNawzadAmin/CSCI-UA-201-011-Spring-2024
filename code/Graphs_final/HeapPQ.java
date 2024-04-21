package Graphs_final;

import java.lang.Math;

public class HeapPQ<E> implements adaptivePriorityQueue<E>{
	static int MAX_HEIGHT = 4;
	static int MAX_SIZE = (int)(Math.pow(2, MAX_HEIGHT + 1)) - 1;
	
	private class entry{
		E element;
		double priority;
		int index;
		entry(double priority, E element){
			this.priority = priority;
			this.element = element;
		}
		void setIndex(int j) {
			index = j;
		}
	}
	
	entry[] array;
	int size = 0;
	
	public int size() {
		return size;
	}
	
	public HeapPQ() {
		array = (entry[])(new Object[MAX_SIZE]);
	};
	
	private void bubbleUp(int current_ind) {
		boolean in_order = false;
		while(!in_order && !isRoot(current_ind)) {
			int parent_ind = (current_ind - 1) / 2;
			if(array[current_ind].priority>array[parent_ind].priority) {
				in_order = true;
			} else {
				entry temp = array[parent_ind];
				array[parent_ind] = array[current_ind];
				array[current_ind] = temp;
				array[parent_ind].setIndex(parent_ind);
				array[current_ind].setIndex(current_ind);
				current_ind = parent_ind;
			}
		}
	}
	
	private void bubbleDown(int current_ind) {
		boolean in_order = false;
		while(!in_order && !isLeaf(current_ind)){
			// find smaller child
			int child_ind_1 = 2 * current_ind + 1;
			int child_ind_2 = 2 * current_ind + 2;
			int smaller_child_ind = child_ind_1;
			if(child_ind_2 < size) {
				if(array[child_ind_1].priority > array[child_ind_2].priority) {
					smaller_child_ind = child_ind_2;
				}
			}
			// swap if needed
			if(array[smaller_child_ind].priority>array[current_ind].priority) {
				in_order = true;
			} else {
				entry temp = array[smaller_child_ind];
				array[smaller_child_ind] = array[current_ind];
				array[current_ind] = temp;
				array[smaller_child_ind].setIndex(smaller_child_ind);
				array[current_ind].setIndex(current_ind);
				current_ind = smaller_child_ind;
			}
		}
	}
	
	public Object put(double priority, E element) {
		array[size] = new entry(priority, element);
		int current_ind = size;
		bubbleUp(current_ind);
		size++;
		return array[current_ind];
	}
	
	private boolean isRoot(int index) {
		return index == 0;
	}
	
	private boolean isLeaf(int index) {
		return 2 * index + 1 >= size;
	}
	
	public void replaceKey(Object u, double key) {
		entry v = (entry)(u);
		double old_priority = v.priority;
		v.priority = key;
		int current_ind = v.index;
		if (key > old_priority) {
			bubbleDown(current_ind);
		} else if (key < old_priority) {
			bubbleUp(current_ind);
		}
	}
	
	public E removeMin() {
		entry remove = array[0];
		array[0] = array[size - 1];
		array[size - 1] = null;
		size--;
		
		int current_ind = 0;
		bubbleDown(current_ind);
		return remove.element;
	}
	
}

