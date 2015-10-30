package datastructures;

import java.util.Arrays;

/**
 * Created by Itai on 30-Oct-15.
 */
public class ArrayList<T> implements List<T> {

    private Object[] data;

    public ArrayList() {
        data = new Object[0];
    }

    private void grow(int n) {
        int size = size();
        size += n;

        data = Arrays.copyOf(data, size);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public void add(T val) {
        grow(1);
        data[size() - 1] = val;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public int indexOf(T val) {
        for (int i = 0; i < data.length; i++) {
            if(data[i].equals(val)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean contains(T val) {
        for(Object obj : data) {
            if(obj.equals(val)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        data = new Object[0];
    }

    @Override
    public boolean equals(LinkedList<T> list) {
        //TODO: Implement
        return false;
    }

    @Override
    public Object[] toArray() {
        return data;
    }
}
