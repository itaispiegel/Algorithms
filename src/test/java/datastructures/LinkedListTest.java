package datastructures;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Itai on 29-Oct-15.
 */
public class LinkedListTest {

    LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();
        list.add(2);
        list.add(5);
    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
    }

    @Test
    public void testContains() throws Exception {
        boolean actual1 = list.contains(5);
        boolean actual2 = list.contains(12);

        assertEquals(true, actual1);
        assertEquals(false, actual2);
    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testClear() throws Exception {
    }
}