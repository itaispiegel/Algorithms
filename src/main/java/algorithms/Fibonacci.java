package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Itai on 14-Oct-15.
 */
public class Fibonacci {

    private static Map<Integer, Integer> fib;

    static {
        fib = new HashMap<>();
        fib.put(0, 0);
        fib.put(1, 1);
    }

    public static int fibonacciRecursively(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
    }

    public static int fibonacciDynamic(int n) {
        if (!fib.containsKey(n)) {
            fib.put(n, fibonacciDynamic(n - 1) + fibonacciDynamic(n - 2));
        }

        return fib.get(n);
    }

    public static int fibonacciFormula(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) ((Math.pow(phi, n) - Math.pow(1 - phi, n)) / Math.sqrt(5));
    }
}
