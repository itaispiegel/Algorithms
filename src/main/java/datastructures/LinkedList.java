package datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Itai on 29-Oct-15.
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T val) {
        Node<T> node = new Node<>(val);

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (isElementIndex(index)) {

            Node<T> currNode = head;

            for (int i = 0; i < index; i++) {
                currNode = currNode.getNext();
            }

            return currNode.getItem();
        }

        return null;
    }

	@Override
	public int indexOf(T val) {
		Node<T> currNode = head;
		
		for (int i = 0; i < size; i++) {
			
			if(currNode.getItem().equals(val)) {
				return i;
			}
			
			currNode = currNode.getNext();
		}
		
		return -1;
	}

    public boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T val) {
        Node<T> currNode = head;

        while (currNode != null) {
            if (currNode.getItem() == val) {
                return true;
            } else {
                currNode = currNode.getNext();
            }
        }

        return false;
    }

    @Override
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;
        for(Node<T> x = head; x != null; x = x.getNext()) {
            array[i] = x.getItem();
            i++;
        }

        return array;
    }

    @Override
    public boolean equals(LinkedList<T> list) {
        return Arrays.equals(toArray(), list.toArray());
    }

    /**
     * Return an iterator that iterates over the items of the LinkedList.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = current.getItem();
            current = current.getNext();
            return item;
        }
    }
}