package datastructures;

public class Bag <E> {
	private int size;
	private E[] array;
	
	private final static int CAPACITY_DEFAULT = 10;
	
	public Bag(int capacity) {
		capacity = (capacity > 0)? capacity : CAPACITY_DEFAULT;
		array = (E[]) new Object[capacity];
		size = 0;
	}
	public Bag() {
		this(CAPACITY_DEFAULT);
	}

	
}
