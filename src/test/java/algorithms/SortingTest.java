package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Itai on 27-Oct-15.
 */
public class SortingTest extends Sorting {

    private int[] arr;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        arr = new int[] {11, 14, 18, 13, 21, 4};
        expected = arr;

        Arrays.sort(expected);
    }

    @Test
    public void testSelectionSort() throws Exception {
        arr = selectionSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testBubbleSort() throws Exception {
        arr = bubbleSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testInsertionSort() throws Exception {
        arr = insertionSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testSwap() throws Exception {
        int i1 = 1;
        int i2 = 3;

        // Swap manually
        int[] tmpArray = arr;

        int tmpVal = arr[i1];
        tmpArray[i1] = arr[i2];
        tmpArray[i2] = tmpVal;
        //----------

        swap(arr, i1, i2);

        assertArrayEquals(arr, tmpArray);
    }

    @Test
    public void testBinarySearch() throws Exception {
        arr = bubbleSort(arr);
        
        int val = 13;
        int index = binarySearch(arr, val);
        int expectedIndex = 2;

        assertEquals(index, expectedIndex);
    }
}