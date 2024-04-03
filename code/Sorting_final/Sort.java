package Sorting_final;

public class Sort {
	public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void bubbleSort(int[] array) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i+1]) {
					sorted = false;
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
		}
	}
	
	public static void selectionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			// find min entry
			int min_ind = i;
			for(int j = i+1; j < array.length; j++) {
				if(array[min_ind] > array[j]) {
					min_ind = j;
				}
			}
			// bring j to front
			for(int j=min_ind; j > i; j--) {
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}
		}
	}
	
	public static void insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j=i; j > 0; j--) {
				if(array[j-1] > array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static int[] merge(int[] array1, int[] array2) {
		int combineLength = array1.length + array2.length;
		int[] combinedArray = new int[combineLength];
		int index1 = 0;
		int index2 = 0;
		for(int i=0; i < combineLength; i++) {
			if(index1 >= array1.length) {
				combinedArray[i] = array2[index2];
				index2++;
			}
			else if(index2 >= array2.length){
				combinedArray[i] = array1[index1];
				index1++;
			}
			else {
				if (array1[index1] > array2[index2]) {
					combinedArray[i] = array2[index2];
					index2++;
				}
				else {
					combinedArray[i] = array1[index1];
					index1++;
				}
			}
		}
		return combinedArray;
	}

	public static void main(String[] args) {
		int[] intarray;
		intarray = new int[]{5, 4, 6, 3, 7, 2, 1, 8};
		System.out.println(isSorted(intarray));
		bubbleSort(intarray);
		selectionSort(intarray);
		insertionSort(intarray);
		for(int i: intarray) {
			System.out.println(i);
		}
		
		int[] intarray1 = new int[]{5, 4, 6, 3};
		int[] intarray2 = new int[]{7, 2, 1, 8};
		insertionSort(intarray1);
		insertionSort(intarray2);
		int[] combArray = merge(intarray1, intarray2);
		System.out.println(isSorted(combArray));
		for(int i: combArray) {
			System.out.println(i);
		}
	}
}
