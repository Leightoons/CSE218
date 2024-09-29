package datastructures;

public interface Indexed<E extends Object & Comparable<E>> {
	E getId();
	
	default int compareIndex(Indexed<E> other) {
		return this.getId().compareTo(other.getId());
	}

}
