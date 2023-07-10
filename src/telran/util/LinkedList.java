package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class LinkedList<T> implements List<T> {
	private static class Node<T> {
		T obj;
		Node<T> next;
		Node<T> prev;
		Node(T obj) {
			this.obj = obj;
		}
	}
private class LinkedListIterator implements Iterator<T>	{
	Node<T> current=head;
	

	@Override
	public boolean hasNext() {
		
		return current!=null;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			 throw new NoSuchElementException();	
		}
		 T obj=current.obj;
		 current=current.next;
		 return obj;
	}
	 @Override
	    public void remove() {
	        throw new UnsupportedOperationException("remove() operation is not supported");
	    }
	
}
	Node<T> head;
	Node<T> tail;
	int size;
	@Override
	public boolean add(T obj) {
		Node<T> node = new Node<>(obj);
		addNode(size, node);
		return true;
	}

	private void addNode(int index, Node<T> node) {
		
		if(index == size) {
			addTail(node);
		} else if (index == 0) {
			addHead(node);
		} else {
			addMiddle(index, node);
		}
		size++;
		
	}

	private void addMiddle(int index, Node<T> node) {
		
		Node<T> nextNode = getNode(index);
		Node<T> prevNode = nextNode.prev;
		node.next = nextNode;
		nextNode.prev = node;
		prevNode.next = node;
		node.prev = prevNode;
		
	}

	private void addHead(Node<T> node) {
		node.next = head;
		head.prev = node;
		head = node;
		
	}

	private void addTail(Node<T> node) {
		if (tail == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
		}
		tail = node;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return  new LinkedListIterator() ;
	}

	@Override
	public void add(int index, T obj) {
		indexValidation(index, true);
		Node<T> node = new Node<>(obj);
		addNode(index, node);

	}

	@Override
	public T get(int index) {
		indexValidation(index, false);
		Node<T> node = getNode(index);
		return node.obj;
	}

	private Node<T> getNode(int index) {
		
		return index < size / 2 ? getNodeFromHead(index) : getNodeFromTail(index);
	}

	private Node<T> getNodeFromTail(int index) {
		Node<T> current = tail;
		for(int i = size - 1; i > index; i--) {
			current = current.prev;
		}
		return current;
	}

	private Node<T> getNodeFromHead(int index) {
		Node<T> current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public T set(int index, T obj) {
		indexValidation(index, false);
		Node<T> current=getNode(index);
		T oldObj=current.obj;
		current.obj=obj;
		
		
		return oldObj;
	}

	@Override
	public T remove(int index) {
		indexValidation(index, true);
		Node<T>node=getNode(index);
		removeNode(node);
		size--;
		return node.obj;
	}

	private void removeNode(Node<T> node) {
		Node<T>prevNode=node.prev;
		Node<T>nextNode=node.next;
		if(prevNode==null) {
			head=node.next;
		}else{
			prevNode.next=node.next;
		}
		if(nextNode==null) {
			tail=node.prev;
		}else {
			nextNode.prev=node.prev;
		}
		
		
	}

	@Override
	public int indexOf(Object pattern) {
		int index=0;
		Node<T> current=head;
		while(current!=null&&!pattern.equals(current.obj)) {
			current=current.next;
			index++;
			
		}
		return index==size?-1:index;
	}

	@Override
	public int lastIndexOf(Object pattern) {
		int index=size-1;
		Node<T>current=tail;
		while(current!=null&&!pattern.equals(current.obj)) {
			index--;
			current=current.prev;
			
		}
		
		return index==0?-1:index;
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int index=0;
		Node<T> current=head;
		while(current!=null&&!predicate.test(current.obj)) {
			current=current.next;
			index++;
			
		}
		return index==size?-1:index;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int index=size-1;
		Node<T>current=tail;
		while(current!=null&&!predicate.equals(current.obj)) {
			index--;
			current=current.prev;
			
		}
		
		return index==0?-1:index;

	}

	

}