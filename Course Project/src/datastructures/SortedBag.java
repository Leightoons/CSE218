package datastructures;


public class SortedBag<E extends Object & Comparable<E>> extends Bag<E> {
	private static final long serialVersionUID = 1L;
	
	private boolean sortReverse;
	
	public SortedBag(int capacity, boolean allowDuplicates, boolean sortReverse) {
		super(capacity, allowDuplicates);
		this.sortReverse = sortReverse;
	}
 	public SortedBag(boolean allowDuplicates) {
		this(allowDuplicates, false);
	}
	public SortedBag(E[] array) {
		this(array, ALLOWDUPES_DEFAULT, false);
	}
	public SortedBag(int capacity, boolean allowDuplicates) {
		this(capacity, allowDuplicates, false);
	}
	public SortedBag(int capacity) {
		this(capacity, ALLOWDUPES_DEFAULT, false);
	}
	public SortedBag() {
		this(CAPACITY_DEFAULT, ALLOWDUPES_DEFAULT, false);
	}
	public SortedBag(boolean allowDuplicates, boolean sortReverse) {
		this(CAPACITY_DEFAULT, allowDuplicates, false);
	}
	public SortedBag(E[] array, boolean allowDuplicates, boolean sortReverse) {
		this(CAPACITY_DEFAULT, ALLOWDUPES_DEFAULT, false);
	}
	

	
	private int findTargetIndex(E element) {
		int low = 0;
		int high = size;
		
		while (low < high) {
			int mid = (high+low)/2;
			int comp = element.compareTo(array[mid]) * (sortReverse? -1 : 1);
			if (comp == 0) return mid;
			else if (comp > 0) high = mid - 1;
			else low = mid + 1;
		}
		if (low == size) return size;
		else return (element.compareTo(array[low])*(sortReverse? -1 : 1) > 0)? low : low+1;
		//return -1;
	}
	
	private void shiftElementsUp(int startIdx) {
		if (size+1 >= array.length) resizeArray();
		System.arraycopy(array, startIdx, array, startIdx+1, size-startIdx);
	}
	
	@Override
	public boolean add(E element) {
		if (!allowDuplicates) {
			if (findIndex(element) >= 0) return false;
		}
		int targetIdx = findTargetIndex(element);
		shiftElementsUp(targetIdx);
		array[targetIdx] = element;
		++size;
		return true;	
	}
	
	@Override
	public boolean remove(E element) {
		int i = findIndex(element);
		if (i < 0) return false;
		System.arraycopy(array, i+1, array, i, size-i);
		array[size--] = null;
		return true;
	}

}
