package datastructures;


public class SortedBag<E extends Object & Comparable<E>> extends Bag<E> {
	public SortedBag() {
		super();
	}
	public SortedBag(boolean allowDuplicates) {
		super(allowDuplicates);
	}
	public SortedBag(E[] array) {
		super(array);
	}
	public SortedBag(int capacity, boolean allowDuplicates) {
		super(capacity, allowDuplicates);
	}
	public SortedBag(int capacity) {
		super(capacity);
	}

	private static final long serialVersionUID = 1L;
	
	private int findTargetIndex(E element) {
		int low = 0;
		int high = size;
		
		while (low < high) {
			int mid = (high+low)/2;
			int comp = element.compareTo(array[mid]);
			if (comp == 0) return mid;
			else if (comp > 0) high = mid - 1;
			else low = mid + 1;
		}
		if (low == size) return size;
		else return (element.compareTo(array[low]) > 0)? low : low+1;
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

}
