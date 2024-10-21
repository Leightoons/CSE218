package binarytree;

class Node<E> {
	private E data;
//	private Node<E> parent;
	private Node<E> left;
	private Node<E> right;
	
	public Node(E data) {
		this.data = data;
		this.left = this.right = null;
	}

	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	

//	public Node<E> getParent() {return parent;}
//
//	public void setParent(Node<E> parent) {this.parent = parent;}
	

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}
	

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}
	
}
