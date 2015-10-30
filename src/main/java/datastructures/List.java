package datastructures;

public interface List<T> {

    /**
     * @return the size of the LinkedList.
     */
    int size();

    /**
     * @return whether the LinkedList is empty.
     */
    boolean isEmpty();

    /**
     * Insert an item to the LinkedList.
     */
    void add(T val);

    /**
     * Get the item stored in the given index.
     */
    T get(int index);

    /**
     * @return index of the given item.
     */
    int indexOf(T val);

    /**
     * @return whether the LinkedList contains the given item.
     */
    boolean contains(T val);

    /**
     * Clear the LinkedList.
     */
    void clear();

    /**
     * Returns true if the two LinkedLists are equal.
     */
    boolean equals(LinkedList<T> list);

    /**
     * Converts linked list to an object array.
     */
    Object[] toArray();
}
