package datastructures;

import java.util.Iterator;

/**
 * Created by Itai on 02-Nov-15.
 */
public class QueueUsingTwoStacks<T> extends Queue<T> {

    private Stack<T> s1;
    private Stack<T> s2;

    public QueueUsingTwoStacks() {
        s1 = new LinkedStack<>();
        s2 = new LinkedStack<>();
    }

    @Override
    public void enqueue(T item) {
        s1.push(item);
    }

    @Override
    public T dequeue() {
        if(s2.isEmpty()) {
            while(s1.size() > 0) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

}
