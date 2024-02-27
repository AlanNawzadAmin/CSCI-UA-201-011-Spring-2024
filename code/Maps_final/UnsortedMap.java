package Maps_final;

import LinkedList_final.GoodList;
import LinkedList_final.DoublyLinkedList;

public class UnsortedMap<K, V> {
	private int size;
	private GoodList<Entry<K, V>> entrylist;
	private class UnsortEntry<K, V> implements Entry<K, V>{
		K key;
		V value;
		UnsortEntry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {return key;};
		public V getValue() {return value;};
	}
	
	public UnsortedMap(){
		entrylist = new DoublyLinkedList<Entry<K, V>>();
	}
	
	int size() {return size;};
	boolean isEmpty() { return size() == 0;};
	GoodList<Entry<K,V>> entrySet(){
		return entrylist;
	};
	GoodList<K> keySet(){
		GoodList<K> keylist = new DoublyLinkedList<K>();
		for (int i = 0; i< entrylist.size(); i++) {
			keylist.addLast(entrylist.getAtIndex(i).getKey());
		}
		return keylist;
		}
	
	GoodList<V> values(){
		GoodList<V> valuelist = new DoublyLinkedList<V>();
		for (int i = 0; i< entrylist.size(); i++) {
			valuelist.addLast(entrylist.getAtIndex(i).getValue());
		}
		return valuelist;
	}
	
	V put(K key, V value) {
		V old_val = get(key);
		if (old_val == null) {
			entrylist.addLast(new UnsortEntry<K, V>(key, value));
			return null;
		}
		else{
			V returnValue = remove(key);
			entrylist.addLast(new UnsortEntry<K, V>(key, value));
			return returnValue;
		}
	};

	
	V get(K key) {
		for (int i = 0; i< entrylist.size(); i++) {
			Entry<K, V> entry = entrylist.getAtIndex(i);
			if (entry.getKey() == key) return entry.getValue();
		}
		return null;
	};

	V remove(K key) {
		for (int i = 0; i< entrylist.size(); i++) {
			Entry<K, V> entry = entrylist.getAtIndex(i);
			if (entry.getKey() == key) {
				((DoublyLinkedList<Entry<K, V>>)entrylist).removeAtIndex(i);
				return entry.getValue();
			}
		}
		return null;
	};
	
	
}
