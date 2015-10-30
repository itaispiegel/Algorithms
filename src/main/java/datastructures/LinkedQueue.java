package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The <tt>LinkedQueue</tt> class represents a first-in-first-out (FIFO)
 * queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em>
 * operations, along with methods for peeking at the top item,
 * testing if the queue is empty, and iterating through
 * the items in FIFO order.
 * <p/>
 * All queue operations except iteration are constant time.
 * <p/>
 * For additional documentation, see <a href="http://introcs.cs.princeton.edu/43stack">Section 4.3</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 */
public class LinkedQueue<T> extends Queue<T> {

    /**
     * First value of the queue.
     * <br/>NOTE: The first value is the first out.
     */
    private Node<T> first;

    /**
     * Last value of the queue.
     * <br/>NOTE: The last value is last out.
     */
    private Node<T> last;

    /**
     * New empty queue.
     */
    public LinkedQueue() {
        super();

        first = null;
        last = null;
    }

    /**
     * <b>Complexity: O(1)</b>
     * <br/>Get the first item of the queue.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedQueue Underflow");
        }

        return first.getItem();
    }

    /**
     * <b>Complexity: O(1)</b>
     * <br/>Add an item to the queue.
     */
    @Override
    public void enqueue(T item) {
        Node<T> x = new Node<>();
        x.setItem(item);

        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.setNext(x);
            last = x;
        }

        size++;
    }

    /**
     * <b>Complexity: O(1)</b>
     * <br/>Remove and return the item on the queue least recently added.
     * Throw an exception if the queue is empty.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("LinkedQueue underflow");
        }

        T item = first.getItem();
        first = first.getNext();
        size--;

        if (isEmpty()) {
            last = null;   // to avoid loitering
        }

        return item;
    }

    /**
     * <b>Complexity: O(n)</b>
     * <br/>Return string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T item : this) {
            sb.append(item).append(" ");
        }

        if(sb.length() >= 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * Return an iterator that iterates over the items on the queue in FIFO order.
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class QueueIterator implements Iterator<T> {
        private Node<T> current = first;

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
