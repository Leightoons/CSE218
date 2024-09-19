import java.util.Arrays;
import java.util.function.*;

public class GenericBag <E extends Object & Comparable<E>> {
	private E[] array;
	private int elementCount;
	
	public GenericBag(int size) {
		array = (E[]) new Object[size];
		elementCount = 0;
	}
	public GenericBag() {
		this(5);
	}
	
	public E find(Predicate<E> filter) {
		for (int i = 0; i < elementCount; i++) {
			if (filter.test(array[i])) {
				return array[i];
			}
		}
		return null;
	}
	
	public E[] findAll(Predicate<E> filter) {
		int matchCount = 0;
		E[] matches = (E[]) new Object[elementCount];
		for (int i = 0; i < elementCount; i++) {
			if (filter.test(array[i])) {
				matches[matchCount++] = array[i];
			}
		}
		return (matchCount == elementCount)? matches : Arrays.copyOf(matches, matchCount);
	}
	
	public void add(E element) {
		array[elementCount++] = element;
	}
	
	public void remove(Predicate<E> filter) {
		E match = find(filter);
		if (match == null) return;
		
	}
	
	public void displayContents() {
		for (int i = 0; i < elementCount; i++) {
			System.out.println(array[i]);
		}
	}
	
}
