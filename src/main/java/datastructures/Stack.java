package datastructures;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Itai on 28-Oct-15.
 */
public abstract class Stack<T> implements Iterable<T> {

    /**
     * Size of the stack.
     */
    protected int size;

    public Stack() {
        this.size = 0;
    }

    /**
     * Is the stack empty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Push an item to the stack.
     */
    public abstract void push(T item);

    /**
     * Remove the top/last item from stack (depends on whether the stack is LIFO or FIFO).
     */
    public abstract T pop();

    /**
     * Get the top/last item from stack (depends on whether the stack is LIFO or FIFO).
     */
    public abstract T peek();

    /**
     * Print the stack
     */
    public abstract String toString();

    /**
     * Return an iterator that iterates over the items on the stack in LIFO order.
     */
    public abstract Iterator<T> iterator();

    /**
     * Converts the stack to a list.
     */
    public List<T> toList() {
        return Lists.newArrayList(iterator());
    }
}
