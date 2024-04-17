package Maps_final;
import LinkedList_final.GoodList;
import LinkedList_final.DoublyLinkedList;


public class HashMap<K, V> implements Map<K, V>{
	private int size;
	private UnsortedMap<K, V> entrylist[];
	public HashMap(){
		entrylist = (UnsortedMap<K, V>[]) new Object[1000];
	};

	public V get(K key) {
		int index = key.hashCode() % 1000;
		return entrylist[index].get(key);
	};
}
