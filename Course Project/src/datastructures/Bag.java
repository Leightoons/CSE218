package datastructures;

import java.util.Arrays;
import java.util.function.*;

public class Bag <E> {
	private int size;
	private E[] array;
	
	private boolean allowDuplicates;
	
	private final static int CAPACITY_DEFAULT = 16;
	
	public Bag(int capacity, boolean allowDuplicates) {
		capacity = (capacity > 0)? capacity : CAPACITY_DEFAULT;
		array = (E[]) new Object[capacity];
		size = 0;
	}
	public Bag(int capacity) {
		this(capacity, false);
	}
	public Bag() {
		this(CAPACITY_DEFAULT);
	}
	
	public int findIndex(Predicate<E> filter) {
		for (int i = 0; i < size; i++) {
			E e = array[i];
			if (filter.test(e)) return i;
		}
		return -1; //item not found
	}
	public int findIndex(E element) {
		return findIndex(e -> e == element);
	}
	
	private boolean resizeArray(int newSize) {
		if (newSize <= size || newSize == array.length) return false;
		E[] newArray = Arrays.copyOf(array, newSize);
		array = newArray;
		return true;
	}

	public boolean add(E element) {
		if (!allowDuplicates) {
			if (findIndex(element) >= 0) return false;
		}
	}
	
}
