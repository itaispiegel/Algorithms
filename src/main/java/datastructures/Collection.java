package datastructures;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Itai on 28-Oct-15.
 */
public abstract class Collection<T> implements Iterable<T> {

    /**
     * Size of the queue.
     */
    protected int size;

    public Collection() {
        this.size = 0;
    }

    /**
     * Is the collection empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the collection.
     */
    public int size() {
        return size;
    }

    /**
     * Push an item to the collection.
     */
    public abstract void push(T item);

    /**
     * Remove the top/last item from collection (depends on whether the collection is LIFO or FIFO).
     */
    public abstract T pop();

    /**
     * Get the top/last item from collection (depends on whether the collection is LIFO or FIFO).
     */
    public abstract T peek();

    /**
     * Print the collection
     */
    public abstract String toString();

    /**
     * Return an iterator that iterates over the items on the queue in FIFO order.
     */
    public abstract Iterator<T> iterator();

    /**
     * Converts the collection to a list.
     */
    public List<T> toList() {
        return Lists.newArrayList(iterator());
    }
}
