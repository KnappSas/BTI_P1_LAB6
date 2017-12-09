package list;

public class MyList<T> {

	private int size;
	private Node<T> first;
	private Node<T> last;

	public MyList() {
		size = 0;
		first = null;
		last = null;
	}

	public T getNo(int no) {
		assert 0 <= no && no < getSize() : "Argument no is not in size";
		return iGetNodeNo(no).getData();
	}

	public T getF() {
		return first.getData();
	}

	public T getL() {
		return last.getData();
	}

	public T extractNo(int no) {
		assert 0 <= no && no < getSize() : "Argument no is not in size";
		Node<T> nodeToExtract = iGetNodeNo(no);
		iRemoveNode(nodeToExtract);
		return nodeToExtract.getData();
	}

	public T extractF() {
		if (!isEmpty()) {
			T ret = first.getData();
			iRemoveNode(first);
			return ret;
		} else {
			return null;
		}
	}

	public T extractL() {
		if (!isEmpty()) {
			T ret = last.getData();
			iRemoveNode(last);
			return ret;
		} else {
			return null;
		}
	}

	public boolean putNo(int no, T element) {
		assert 0 <= no && no <= getSize() : "Argument no is not in size";
		assert element != null : "Argument can't be null!";

		Node<T> newNode = new Node<>(element);
		Node<T> node = iGetNodeNo(no);

		if (no > size)
			return false;

		if (size == 0) {
			first = newNode;
			last = first;
		} else if (no == 0) {
			node.setPrevious(newNode);
			newNode.setNext(node);
			first = newNode;
		} else if (no == size) {
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
		} else {
			node.getPrevious().setNext(newNode);
			newNode.setPrevious(node.getPrevious());
			node.setPrevious(newNode);
			newNode.setNext(node);
		}

		size++;
		return true;
	}

	public void putF(T element) {
		Node<T> firstNode = first;
		if (!isEmpty()) {
			Node<T> newFirstNode = new Node<>(element);
			firstNode.setPrevious(newFirstNode);
			newFirstNode.setNext(firstNode);
			first = newFirstNode;
		} else {
			first = new Node<>(element);
			last = first;
		}

		size++;
	}

	public void putL(T element) {
		Node<T> lastNode = last;
		if (!isEmpty()) {
			Node<T> newLastNode = new Node<>(element);
			lastNode.setNext(newLastNode);
			newLastNode.setPrevious(lastNode);
			last = newLastNode;
		} else {
			last = new Node<>(element);
			first = last;
		}

		size++;
	}

	public T setNo(int no, T element) {
		assert 0 <= no && no < getSize() : "Argument no is not in size";
		assert element != null : "Argument can't be null!";
		Node<T> node = iGetNodeNo(no);

		Node<T> newNode = new Node<>(element);
		newNode.setNext(node.getNext());

		if (node == first) {
			if (first.hasNext())
				first.getNext().setPrevious(newNode);
			newNode.setNext(first.getNext());
			first = newNode;
		} else {
			newNode.setPrevious(node.getPrevious());
			node.getPrevious().setNext(newNode);
			if (node.hasNext())
				node.getNext().setPrevious(newNode);
		}

		return node.getData();
	}

	public void removeNo(int no) {
		iRemoveNode(iGetNodeNo(no));
	}

	public boolean remove(T element) {
		return iRemoveNode(iSearchNode(element));
	}

	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public boolean contains(T element) {
		assert element != null : "Argument can't be null!";
		return iSearchNode(element) != null;
	}

	private Node<T> iGetNodeNo(int no) {
		// assert 0 <= no && no < getSize() : "Argument no is not in size";
		Node<T> node;
		node = first;
		if (node == null || size < no)
			return null;

		for (int i = 0; i < no; i++) {
			node = node.getNext();
		}

		return node;
	}

	private Node<T> iSearchNode(T element) {
		assert element != null : "Argument can't be null!";
		Node<T> node = first;
		while (node != null) {
			if (node.getData().equals(element))
				return node;
			node = node.getNext();
		}
		return node;
	}

	private boolean iRemoveNode(Node<T> node) {
		boolean removed = false;

		if (node == null)
			return removed;

		if (node != first && node != last) {
			node.getPrevious().setNext(node.getNext());
			node.getNext().setPrevious(node.getPrevious());
			removed = true;
		}
		if (node == first) {
			first = node.getNext();
			if (first != null)
				first.setPrevious(null);
			removed = true;
		}
		if (node == last) {
			last.setNext(null);
			last = node.getPrevious();
			removed = true;
		}

		if (removed)
			size--;

		return removed;
	}
}
