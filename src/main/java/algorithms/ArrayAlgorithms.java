package algorithms;

/**
 * This class contains an assortment of algorithms relating to arrays - mainly sorting algorithms.
 */
public class ArrayAlgorithms {

    /**
     * <b>Complexity: O(n^2)</b>
     * <br/>Search through the array, find largest value, exchange with first array value.
     * <br/>Search through rest of array, find second-largest value, exchange with second array value, and so forth.
     */
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            swap(arr, index, i);
        }
    }

    /**
     * <b>Complexity: O(n^2)</b>
     * <br/> Starting from the beginning of the array, compare every adjacent pair and
     * swap them if they are not in the right order.
     * After each iteration, one less element (the last one) is needed to be compared until there are no more elements left to be compared.
     */
    public void bubbleSort(int[] arr) {

        // i is left value, and j is right value
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * <b>Complexity: O(n^2)</b>
     * <br>Each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list,
     * and inserts it there. It repeats until no input elements remain.
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];

            int j;

            // Slide array values and insert the relevant one.
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
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
     */
    public void shellSort(int[] arr) {
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
    }

    /**
     * {@link #quickSort(int[], int, int)}
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * <b>Best Complexity: O(n log(n))
     * <br/>Average Complexity: O(n log(n))
     * <br/>Worst Complexity: O(n ^ 2)
     * <br/>Worst Space Complexity: O(log n)</b>
     * <p>
     * <p>
     * Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller sub-arrays:
     * the low elements and the high elements.
     * Quicksort can then recursively sort the sub-arrays.</p>
     * <p>
     * <p>The steps are:</p>
     * <ul>
     * <li>Pick an element, called a pivot, from the array.</li>
     * <li>{@link #partition(int[], int, int)}.</li>
     * <li>Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array
     * of elements with greater values.</li>
     * </ul>
     */
    public void quickSort(int[] arr, int left, int right) {

        if(left < right) {
            //Border of partition
            int pivotIndex = partition(arr, left, right);

            //Sort left half
            quickSort(arr, left, pivotIndex);

            //Sort right half
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * <p><b>Best Complexity: O(n log(n))
     * <br/>Average Complexity: O(n log(n))
     * <br/>Worst Complexity: O(n log(n))
     * <br/>Worst Space Complexity: O(n)</b></p>
     * <p>
     * Divide the array into n sublists, each containing 1 element, and repeatedly merge sublists
     * to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.</p>
     */
    public int[] mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            int[] newArray = new int[1];
            newArray[0] = arr[start];

            return newArray;
        }

        int[] left = mergeSort(arr, start, (start + end) / 2);
        int[] right = mergeSort(arr, (start + end) / 2 + 1, end);

        return merge(left, right);
    }

    /**
     * Merge two arrays in a sorted way.
     * @return a sorted array which contains values from both sub arrays.
     */
    public int[] merge(int[] left, int[] right) {
        int[] mergedArray = new int[left.length + right.length];

        int i = 0;
        int j = 0;

        while (i + j < mergedArray.length) {

            if (i == left.length) {
                mergedArray[i + j] = right[j];
                j++;
            } else if (j == right.length) {
                mergedArray[i + j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                mergedArray[i + j] = left[i];
                i++;
            } else {
                mergedArray[i + j] = right[j];
                j++;
            }
        }

        return mergedArray;
    }

    /**
     * <b>Best Complexity: O(n)
     * <br/>Average Complexity: O(n)
     * <br/>Worst Complexity: O(n^2)</b>
     * <p>
     * <p>An algorithm used to find the kth smallest element in an unsorted array.</p>
     * <br/>The steps are:
     * <ul>
     * <li>Pick an element, called a pivot, from the array.</li>
     * <li>{@link #partition(int[], int, int)}.</li>
     * <li>Search for the element in the partitioned side.</li>
     * </ul>
     *
     * @return Kth smallest element in the array.
     */
    public int quickSelect(int[] arr, int left, int right, int k) {

        //If the array has only one element, return it
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    /**
     * {@link #quickSelect(int[], int, int, int)}
     */
    public int quickSelect(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    /**
     * <b>Complexity: O(n)</b>
     * <p>Reorder the array so that all elements with values less than the pivot come before the pivot,
     * while all elements with values greater than the pivot come after it (equal values can go either way).
     * After this partitioning, the pivot is in its final position.
     * This is called the partition operation.</p>
     */
    public int partition(int[] arr, int left, int right) {
        int pivotIndex = (left + right) / 2;
        int pivotVal = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if(arr[i] < pivotVal) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, right, storeIndex);
        return storeIndex;
    }

    /**
     * <b>Complexity: O(1)</b>
     * <br/>Swap two values in an array.
     */
    public void swap(int[] arr, int i1, int i2) {
        if (i1 != i2) {
            int tmp = arr[i1];
            arr[i1] = arr[i2];
            arr[i2] = tmp;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int binarySearch(int[] arr, int val) {
        return binarySearch(arr, val, 0, arr.length - 1);
    }

    /**
     * <b>Complexity: O(log n)</b>
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

        if (right < left) {
            return -1;
        }

        if (arr[index] == val) {
            return index;
        } else if (arr[index] < val) {
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
        for (int x : arr) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
