package datastructures;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Itai on 28-Oct-15.
 */
public abstract class Queue<T> implements Iterable<T> {

    /**
     * Size of the queue.
     */
    protected int size;

    public Queue() {
        this.size = 0;
    }

    /**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Insert an item to the queue.
     */
    public abstract void enqueue(T item);

    /**
     * Remove the top/last item from queue (depends on whether the queue is LIFO or FIFO).
     */
    public abstract T dequeue();

    /**
     * Get the top/last item from queue (depends on whether the queue is LIFO or FIFO).
     */
    public abstract T peek();

    /**
     * Print the queue
     */
    public abstract String toString();

    /**
     * Return an iterator that iterates over the items on the queue in FIFO order.
     */
    public abstract Iterator<T> iterator();

    /**
     * Converts the queue to a list.
     */
    public List<T> toList() {
        return Lists.newArrayList(iterator());
    }
}
