package datastructures;

/**
 * Created by Itai on 29-Oct-15.
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(T val) {
        Node<T> node = new Node<>(val);

        if(head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }
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

        while(currNode != null) {
            if(currNode.getItem() == val) {
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
}