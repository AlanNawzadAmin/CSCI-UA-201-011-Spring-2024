package Trees_final;
import LinkedList_final.GoodList;

public interface Tree<E>{
	public Position<E> root();
	
	public Position<E> parent(Position<E> p);
	public GoodList< Position<E> > children(Position<E> p);
	boolean isInternal(Position<E> p);
	boolean isExternal(Position<E> p);
	boolean isRoot(Position<E> p);
	int numChildren(Position<E> p);
	int size();
	boolean isEmpty();
	GoodList<Position<E>> positions();
}
