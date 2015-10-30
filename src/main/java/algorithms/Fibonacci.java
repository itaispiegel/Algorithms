package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itai on 14-Oct-15.
 */
public class Fibonacci {

    private static Map<Integer, Integer> fib;

    public static void main(String[] args) {

        fib = new HashMap<>();
        fib.put(0, 0);
        fib.put(1, 1);

        int n = 5;

        //Recursively
        new Thread(() -> {
            long startTime = System.nanoTime();
            int result = fibonacciRecursively(n);
            long endTime = System.nanoTime();

            System.out.println("Recursively: The result is " + result + " and it took " + (endTime - startTime));

        }).run();

        //Dynamic
        new Thread(() -> {
            long startTime = System.nanoTime();
            int result = fibonacciRecursively(n);
            long endTime = System.nanoTime();

            System.out.println("Dynamic: The result is " + result + " and it took " + (endTime - startTime));

        }).run();
    }

    private int f(Integer i1, Integer i2) {
        return i1.compareTo(i2);
    }

    private static int fibonacciRecursively(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);

    }

    private static int fibonacciDynamic(int n) {

        if (!fib.containsKey(n)) {
            fib.put(n, fibonacciDynamic(n - 1) + fibonacciDynamic(n - 2));
        }

        return fib.get(n);
    }

}
