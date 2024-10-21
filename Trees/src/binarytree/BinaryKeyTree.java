package binarytree;

import util.Keyed;

public class BinaryKeyTree<E extends Keyed<T>, T extends Comparable<T>> {
	private Node root;

	public Node getRoot() {
		return root;
	}
	
	public Node searchNode(T key) {
		return searchNode(root, key);
	}
	private Node searchNode(Node rootNode, T key) {
		if (rootNode != null) {
			int comp = rootNode.data.compareKey(key);
			if (comp != 0)
				return (comp > 0)? searchNode(rootNode.left, key) : searchNode(rootNode.right, key);
		}
		return rootNode;
	}

	public boolean contains(T key) {
		return searchNode(key) != null;
	}

	public Node add(E entry) {
		Node newNode = new Node(entry);
		if (root == null) root = newNode;
		else {
			Node node = root;
			while (true) {
				int comp = node.data.compareTo(entry);
				if (comp > 0) {
					if (node.left == null) {
						node.left = newNode;
						break;
					}
					else node = node.left;
				}
				else if (comp < 0) {
					if (node.right == null) {
						node.right = newNode;
						break;
					}
					else node = node.right;
				}
				else {
					System.out.printf("ERROR: Entry with key \'%s\' already exists\n", entry.getKey().toString());
					return null;
				}
			}
		}
		return newNode;
	}

	public boolean delete(E entry) {
		return delete(root, entry) != null;
	}
	private Node delete(Node rootNode, E entry) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public class Node {
		private E data;
		//private Node parent;
		private Node left;
		private Node right;
		
		public Node(E data) {
			this.data = data;
		}
	}
}
