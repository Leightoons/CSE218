package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.*;

public class Bag <E> implements Iterable<E> {
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
	private boolean resizeArray() {
		return resizeArray(size*2);
	}

	public boolean add(E element) {
		if (!allowDuplicates) {
			if (findIndex(element) >= 0) return false;
		}
		if (size >= array.length) {
			resizeArray();
		}
		array[size++] = element;
		return true;
	}
	
	public boolean remove(E element) {
		int i = findIndex(element);
		if (i < 0) return false;
		array[i] = array[--size];
		array[size-1] = null;
		return true;
	}
	
	private class BagIterator implements Iterator<E> {
		Bag<E> bag;
		int i;
		
		public BagIterator(Bag<E> bag) {
			i = 0;
			this.bag = bag;
		}
		
		@Override
		public boolean hasNext() {
			return i < bag.size;
		}

		@Override
		public E next() {
			return bag.array[i++];
		}
		
	}
	@Override
	public Iterator<E> iterator() {
		return new BagIterator(this);
	}
	
}
