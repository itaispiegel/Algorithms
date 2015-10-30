package datastructures;

public interface List<T> {

    int size();

    boolean isEmpty();

    void add(T val);

    boolean contains(T val);

    void clear();

    boolean equals(Object o);
}
