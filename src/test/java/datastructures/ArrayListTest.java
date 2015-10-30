package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Itai on 30-Oct-15.
 */
public class ArrayListTest extends ArrayList<Integer> {

    private ArrayList<Integer> arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
    }

    @Test
    public void testSize() throws Exception {
        int expected = 4;
        int actual = arrayList.size();

        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(arrayList.isEmpty(), false);
    }

    @Test
    public void testAdd() throws Exception {
        arrayList.add(14);
    }

    @Test
    public void testGet() throws Exception {
        int index = 2;

        int expected = 7;
        int actual = arrayList.get(index);

        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOf() throws Exception {
        int val = 7;

        int expected = 2;
        int actual = arrayList.indexOf(val);

        assertEquals(expected, actual);
    }

    @Test
    public void testContains() throws Exception {
        int val1 = 7;
        int val2 = 38;

        assertTrue(arrayList.contains(val1));
        assertFalse(arrayList.contains(val2));
    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {
    }
}