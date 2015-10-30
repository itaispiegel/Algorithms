package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Itai on 29-Oct-15.
 */
public class LinkedListTest {

    private LinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<>();

        list.add(2);
        list.add(5);
        list.add(7);
        list.add(9);
    }

    @Test
    public void testSize() throws Exception {
    	int expectedSize = 4;
    	int actualSize = list.size();
    	
    	assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testIsEmpty() throws Exception {
    	Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd() throws Exception {
    	list.add(15);
    	
    	int[] expected = new int[]{2, 5, 7, 9, 15};
        int[] actual = getIntegerArray();
        
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(list.contains(5));
        assertFalse(list.contains(12));
    }

    @Test
    public void testClear() throws Exception {
    	list.clear();
    	assertEquals(list.size(), 0);
    }

    @Test
    public void testGet() throws Exception {

        //Convert list to integer array.
        int[] expected = new int[list.size()];

        for(int i = 0; i < list.toArray().length; i++) {
            int tmp = (int) list.toArray()[i];
            expected[i] = tmp;
        }

        int[] actual = getIntegerArray();

        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testIndexOf() throws Exception {
    	int val1 = 7;
    	int expected1 = 2;
    	int actual1 = list.indexOf(val1);
    	
    	int val2 = 128;
    	int expected2 = -1;
    	int actual2 = list.indexOf(val2);
    	
    	assertEquals(actual1, expected1);
    	assertEquals(actual2, expected2);
    }

	private int[] getIntegerArray() {
		int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
	}

    @Test
    public void testIsElementIndex() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        LinkedList<Integer> equalList = new LinkedList<>();
        equalList.add(2);
        equalList.add(5);
        equalList.add(7);
        equalList.add(9);

        LinkedList<Integer> differentList = new LinkedList<>();
        differentList.add(1);
        differentList.add(2);
        differentList.add(3);
        differentList.add(4);

        assertTrue(list.equals(equalList));
        assertFalse(list.equals(differentList));
    }
}