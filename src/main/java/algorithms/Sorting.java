package algorithms;

/**
 * Created by Itai on 27-Oct-15.
 */
public class Sorting {

    /**
     * <b>Complexity: O(n^2)</b>
     * <br/>Search through the array, find largest value, exchange with first array value.
     * <br/>Search through rest of array, find second-largest value, exchange with second array value, and so forth.
     */
    public int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            swap(arr, index, i);
        }
        return arr;
    }

    /**
     * <b>Complexity: O(n^2)</b>
     * <br/> Starting from the beginning of the array, compare every adjacent pair and
     * swap them if they are not in the right order.
     * After each iteration, one less element (the last one) is needed to be compared until there are no more elements left to be compared.
     */
    public int[] bubbleSort(int[] arr) {

        // i is left value, and j is right value
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        return arr;
    }

    /**
     * <b>Complexity: O(n^2)</b>
     * <br>Each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list,
     * and inserts it there. It repeats until no input elements remain.
     */
    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];

            int j;

            // Slide array values and insert the relevant one.
            for (j = i - 1; j >= 0 && tmp < arr[j] ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }

        return arr;
    }


    /**
     * Shell sort - simple sorting algorithm.
     * <p>
     * <ul>
     * <li>Depends on input data order. Very efficient for small data and partially
     * sorted data.
     * <li>The fastest simple sorting algorithm
     * <li>Quadratic complexity
     * <li>Not stable
     * <li>In-place
     * <li>Online
     * </ul>
     * <p>
     * <table>
     * <tr>
     * <th>Input</th>
     * <th>Complexity</th>
     * </tr>
     * <tr>
     * <td>Random</td>
     * <td>O(N^1.5)</td>
     * </tr>
     * <tr>
     * <td>Sorted</td>
     * <td>O(N)</td>
     * </tr>
     * <tr>
     * <td>Reverse sorted</td>
     * <td>O(N^2)</td>
     * </tr>
     * </table>
     *
     * @see <a href="http://en.wikipedia.org/wiki/Shell_sort">wikipedia</a>
     *
     */
    public int[] shellSort(int[] arr) {
        int interval = 1;

        // Calculate initialized interval
        while (interval < arr.length / 3) {
            interval = 3 * interval + 1; // 1, 4, 13, 40
        }

        while (interval >= 1) {

            for (int i = interval; i < arr.length; i++) {
                for (int j = i; j >= interval && arr[j] < arr[j - interval]; j -= interval) {
                    swap(arr, j, j - interval);
                }
            }

            interval /= 3;
        }

        return arr;
    }

    /**
     * <b>Complexity: O(1)</b>
     * <br/>Swap two values in an array.
     */
    public void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    /**
     * {@inheritDoc}
     */
    public int binarySearch(int[] arr, int val) {
        return binarySearch(arr, val, 0, arr.length - 1);
    }

    /**
     * <b>Complexity: O(logn)</b>
     * <br/>The binary search algorithm begins by comparing the target value to the value of the middle element of the sorted array.
     * If the target value is equal to the middle element's value, then the position is returned and the search is finished.
     * If the target value is less than the middle element's value, then the search continues on the lower half of the array;
     * or if the target value is greater than the middle element's value, then the search continues on the upper half of the array.
     * This process continues, eliminating half of the elements, and comparing the target value to the value of the middle element of the
     * remaining elements - until the target value is either found (and its associated element position is returned), or until the entire
     * array has been searched (and "not found" is returned).
     */
    public int binarySearch(int[] arr, int val, int left, int right) {
        int index = (left + right) / 2;

        if(right < left) {
            return -1;
        }

        if(arr[index] == val) {
            return index;
        } else if(arr[index] < val) {
            return binarySearch(arr, val, index + 1, right);
        } else {
            return binarySearch(arr, val, left, index - 1);
        }
    }

    /**
     * Complexity: O(n)
     * Prints an array.
     */
    public void printArray(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
