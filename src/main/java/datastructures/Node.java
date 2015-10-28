package datastructures;

/**
 * Created by Itai on 28-Oct-15.
 */
public class Node<T> {

    private T item;
    private Node<T> next;

    public Node() {
    }

    public Node(T item, Node<T> next) {
        this.item = item;

        // Avoid NullPointerException
        if(next.getItem() == null) {
            this.next = null;
        } else {
            this.next = next;
        }
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
