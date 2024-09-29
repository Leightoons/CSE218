package datastructures;

public interface Indexed<E extends Object & Comparable<E>> {
	E getId();
	
	// this doesnt work but it can stay for now
	default int compareIndex(Indexed<E> other) {
		return this.getId().compareTo(other.getId());
	}

}
