package algorithms;

/**
 * Created by Itai on 29-Oct-15.
 */
public class Bitwise {

    /**
     * Checks if n XOR (n - 1) is 0.
     */
    public boolean isPowerOf2(long n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    /**
     * Swaps two values in an array using bitwise operators.
     */
    public void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
