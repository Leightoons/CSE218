package datastructures;

import java.io.*;
import java.util.*;
import java.util.function.*;

public class Bag <E> implements Iterable<E>, Serializable {
	private static final long serialVersionUID = 1L;
	protected static final int CAPACITY_DEFAULT = 8;
	protected static final boolean ALLOWDUPES_DEFAULT = true;
	
	protected int size;
	protected E[] array;
	
	protected boolean allowDuplicates;
	
	public Bag(int capacity, boolean allowDuplicates) {
		this.allowDuplicates = allowDuplicates;
		capacity = (capacity > 0)? capacity : CAPACITY_DEFAULT;
		array = (E[]) new Object[capacity];
		size = 0;
	}
	public Bag(int capacity) {
		this(capacity, ALLOWDUPES_DEFAULT);
	}
	public Bag(boolean allowDuplicates) {
		this(CAPACITY_DEFAULT, allowDuplicates);
	}
	public Bag() {
		this(CAPACITY_DEFAULT, ALLOWDUPES_DEFAULT);
	}
	public Bag(E[] array) {
		this(array.length);
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
	}
	
	public int findIndex(Predicate<E> filter) {
		for (int i = 0; i < size; i++) {
			E e = array[i];
			if (filter.test(e)) return i;
		}
		return -1; //item not found
	}
	public int findElementIndex(E element) {
		return findIndex(e -> element.equals(e));
	}
	
	public E find(Predicate<E> filter) {
		int i = findIndex(filter);
		return (i < 0)? null : array[i];
	}
	public E findElement(E element) {
		int i = findElementIndex(element);
		return (i < 0)? null : array[i];
	}
	
	protected boolean resizeArray(int newSize) {
		if (newSize <= size || newSize == array.length) return false;
		E[] newArray = Arrays.copyOf(array, newSize);
		array = newArray;
		return true;
	}
	protected boolean resizeArray() {
		return resizeArray((size > 0)? size*2 : 1);
	}

	public boolean add(E element) {
		if (!allowDuplicates) {
			if (findElementIndex(element) >= 0) return false;
		}
		if (size >= array.length) {
			resizeArray();
		}
		array[size++] = element;
		return true;
	}
	
	public boolean remove(E element) {
		int i = findElementIndex(element);
		if (i < 0) return false;
		array[i] = array[--size];
		array[size] = null;
		return true;
	}
	public boolean remove(Predicate<E> filter) {
		E element = find(filter);
		if (element == null) return false;
		return remove(element);
	}
	
	public E[] toArray() {
		return Arrays.copyOf(array, size);
	}
	
	@Override
	public String toString() {
		return String.format("Bag[%s]", Arrays.toString(toArray()));
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
