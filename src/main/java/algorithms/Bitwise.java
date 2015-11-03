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

    public String toBinary(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Method argument cannot be negative.");
        }

        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            sb.append(n % 2);
            n /= 2;
        }

        return sb.reverse().toString();
    }
}
