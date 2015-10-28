package datastructures;

import java.util.List;

/**
 * Created by Itai on 28-Oct-15.
 */
public interface Collection<T> {

    /**
     * Is the collection empty?
     */
    boolean isEmpty();

    /**
     * Get the size of the collection.
     */
    int size();

    /**
     * Push an item to the collection.
     */
    void push(T item);

    /**
     * Remove the top/last item from collection (depends on whether the collection is LIFO or FIFO).
     */
    T pop();

    /**
     * Get the top/last item from collection (depends on whether the collection is LIFO or FIFO).
     */
    T peek();

    /**
     * Print the collection
     */
    String toString();

    List<T> toList();
}
