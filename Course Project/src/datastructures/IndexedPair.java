package datastructures;

/***
 * Basic dummy class for testing with IndexedBag
 * @param <E>
 * @param <T>
 */
public class IndexedPair<E, T extends Comparable<T>> implements Indexed<T>{
	public E value;
	public T id;
	
	public IndexedPair(E value, T id) {
		this.value = value;
		this.id= id;
	}
	
	@Override
	public T getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", value=" + value + "]";
	}
	
}