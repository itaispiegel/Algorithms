package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Itai on 27-Oct-15.
 */
public class ArrayAlgorithmsTest extends ArrayAlgorithms {

    private int[] arr;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        arr = new int[]{11, 14, 18, 13, 21, 4};
        expected = new int[arr.length];

        System.arraycopy(arr, 0, expected, 0, arr.length);

        Arrays.sort(expected);
    }

    @Test
    public void testSelectionSort() throws Exception {
        selectionSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testBubbleSort() throws Exception {
        bubbleSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testInsertionSort() throws Exception {
        insertionSort(arr);
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
        bubbleSort(arr);

        int val = 13;
        int index = binarySearch(arr, val);
        int expectedIndex = 2;

        assertEquals(index, expectedIndex);
    }

    @Test
    public void testShellSort() throws Exception {
        shellSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testQuickSort() throws Exception {
        quickSort(arr);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testQuickSelect() throws Exception {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        quickSort(sorted);

        //Assert every value in the array
        for (int i = 0; i < sorted.length; i++) {
            int val = sorted[i];
            int select = quickSelect(arr, i);

            assertEquals(select, val);
        }
    }

    @Test
    public void testMergeSort() throws Exception {
        arr = mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testPartition() throws Exception {
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {512, 13, 19, 21, 17, 4, 8, 2, 11, 273};

        assertArrayPartitioned(arr);
        assertArrayPartitioned(arr2);
        assertArrayPartitioned(arr3);
    }

    private void assertArrayPartitioned(int[] arr) {
        int pivotVal = arr[(arr.length - 1) / 2];
        int pivotIndex = partition(arr, 0, arr.length - 1);

        assertEquals(arr[pivotIndex], pivotVal);

        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] < pivotVal);
        }

        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] > pivotVal);
        }
    }
}