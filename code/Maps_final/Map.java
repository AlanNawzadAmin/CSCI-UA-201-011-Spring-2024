package Maps_final;
import LinkedList_final.GoodList;

public interface Map<K, V> {
	int size();
	boolean isEmpty();
	V get(K key);
	V put(K key, V value);
	V remove(K key);
	
	GoodList<K> keySet();
	GoodList<V> values();
	GoodList<Entry<K,V>> entrySet();
}