package datastructures;

public class IndexedBag<E extends Object & Indexed<T>, T extends Object & Comparable<T>> extends Bag<E> {
	private static final long serialVersionUID = 1L;
	
	private boolean sortReverse;
	
	public IndexedBag(int capacity, boolean allowDuplicates, boolean sortReverse) {
		super(capacity, allowDuplicates);
		this.sortReverse = sortReverse;
	}
 	public IndexedBag(boolean allowDuplicates) {
		this(allowDuplicates, false);
	}
	public IndexedBag(int capacity, boolean allowDuplicates) {
		this(capacity, allowDuplicates, false);
	}
	public IndexedBag(int capacity) {
		this(capacity, ALLOWDUPES_DEFAULT, false);
	}
	public IndexedBag(boolean allowDuplicates, boolean sortReverse) {
		this(CAPACITY_DEFAULT, allowDuplicates, false);
	}
	public IndexedBag() {
		this(CAPACITY_DEFAULT, ALLOWDUPES_DEFAULT, false);
	}
	
	public int findIndex(T id) {
		int low = 0, high = size-1;
		while (low <= high) {
			int mid = (high+low)/2;
			int comp = id.compareTo(array[mid].getId());
			if (comp == 0) return mid;
			else if (comp > 0) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	@Override
	public int findElementIndex(E element) {
		return findIndex(element.getId());
	}
	
	private int findTargetIndex(T id) {
		int low = 0, high = size-1;
		while (low < high) {
			int mid = (high+low)/2;
			int comp = id.compareTo(array[mid].getId()) * (sortReverse? -1 : 1);
			if (comp == 0) return mid;
			else if (comp > 0) high = mid - 1;
			else low = mid + 1;
		}
		if (low == size) return size;
		else return (id.compareTo(array[low].getId())*(sortReverse? -1 : 1) > 0)? low : low+1;
		//return -1;
	}
	private int findElementTargetIndex(E element) {
		return findTargetIndex(element.getId());
	}
	
	private void shiftElementsUp(int startIdx) {
		if (size+1 >= array.length) resizeArray();
		System.arraycopy(array, startIdx, array, startIdx+1, size-startIdx);
	}
	
	@Override
	public boolean add(E element) {
		if (!allowDuplicates) {
			if (findElementIndex(element) >= 0) return false;
		}
		int targetIdx = findElementTargetIndex(element);
		shiftElementsUp(targetIdx);
		array[targetIdx] = element;
		++size;
		return true;	
	}
	
	@Override
	public boolean remove(E element) {
		int i = findElementIndex(element);
		if (i < 0) return false;
		System.arraycopy(array, i+1, array, i, size-i);
		array[size--] = null;
		return true;
	}

}
