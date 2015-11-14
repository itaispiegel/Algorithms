package datastructures;

/**
 * Created by eidan on 14/11/2015.
 */
@SuppressWarnings("unchecked")
public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 10;
    private LinkedList[] array;

    private int size;
    private int maxSize;

    public HashMap() {
        size = 0;
        maxSize = DEFAULT_SIZE;
        array = new LinkedList[maxSize];
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % maxSize;

        if(array[index] == null) {
            LinkedList<Entry<K, V>> list = new LinkedList<>();
            list.add(new Entry<>(key, value));
        } else {
            LinkedList<Entry<K, V>> list = array[index];
            list.add(new Entry<>(key, value));
        }

        // make hashmap grow when it reaches a certain size...

    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % maxSize;

        if(array[index] == null) {
            return null;
        } else {
            LinkedList<Entry<K,V>> list = array[index];
            for(Entry<K, V> entry : list) {
                if(entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        //Entry with given key not found
        return null;
    }

    public class Entry<Key, Value> {
        private Key key;
        private Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }
}
