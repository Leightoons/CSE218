package datastructures;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class IndexedTree<E extends Indexed<T>, T extends Comparable<T>> implements Serializable, Iterable<E>{
	private static final long serialVersionUID = 1L;
	private TreeMap<T,E> tree;
	
	public IndexedTree() {
		tree = new TreeMap<T,E>();
	}
	
	public int getSize() {
		return tree.size();
	}
	
	public E find(T key) {
		return tree.get(key);
	}
	public E find(E entry) {
		return tree.get(entry.getId());
	}

	public boolean contains(T key) {
		return tree.containsKey(key);
	}
	public boolean contains(E entry) {
		return tree.containsKey(entry.getId());
	}
	
	public E add(E entry) {
		return tree.put(entry.getId(), entry);
	}
	
	public E remove(T key) {
		return tree.remove(key);
	}
	public E remove(E entry) {
		return remove(entry.getId());
	}
	
	public String toString() {
		return tree.toString();
	}

	public E getRandomElement() {
		int r = (int)(Math.random()*tree.size());
		return (E) tree.values().toArray()[r];
	}
	
	public Object[] toArray() {
		return tree.values().toArray();
	}
	
	@Override
	public Iterator<E> iterator() {
		return tree.values().iterator();
	}
	
}
