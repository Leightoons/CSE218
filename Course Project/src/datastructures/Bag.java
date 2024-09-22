package datastructures;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class Bag <E> implements Iterable<E>, Serializable {
	private static final long serialVersionUID = 1L;
	private static final int CAPACITY_DEFAULT = 16;
	private static final boolean ALLOWDUPES_DEFAULT = true;
	
	private int size;
	private E[] array;
	
	private boolean allowDuplicates;
	
	
	public Bag(int capacity, boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
		capacity = (capacity > 0)? capacity : CAPACITY_DEFAULT;
		array = (E[]) new Object[capacity];
		size = 0;
	}
	public Bag(int capacity) {
		this(capacity, ALLOWDUPES_DEFAULT);
	}
	public Bag() {
		this(CAPACITY_DEFAULT, ALLOWDUPES_DEFAULT);
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
	
	public E find(Predicate<E> filter) {
		int i = findIndex(filter);
		return (i < 0)? null : array[i];
	}
	public E find(E element) {
		int i = findIndex(element);
		return (i < 0)? null : array[i];
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
		array[size] = null;
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
