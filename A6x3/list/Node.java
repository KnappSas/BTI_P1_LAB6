package list;

public class Node<T> {
	private T data;
	private Node<T> next;
	private Node<T> previous;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public Node<T> getPrevious() {
		return previous;
	}
	
	public boolean hasNext() {
		return next != null;
	}
	
	public boolean hasPrevious() {
		return previous != null;
	}

	public void setNext(Node<T> newNext) {
		next = newNext;
	}

	public void setPrevious(Node<T> newPrevElement) {
		previous = newPrevElement;
	}
}
