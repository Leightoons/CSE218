package util;

public interface Keyed<E extends Comparable<E>> {
	E getKey();
	
	default int compareTo(Keyed<E> other) {
		return this.getKey().compareTo(other.getKey());
	}
	
	default int compareKey(E otherKey) {
		return this.getKey().compareTo(otherKey);
	}

}
