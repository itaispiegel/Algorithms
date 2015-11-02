package algorithms;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Itai on 01-Nov-15.
 */
public class FibonacciTest extends Fibonacci {

    private void assertFibonacci(FibonacciFunction func) {
        assertEquals(func.compute(4), 3);
        assertEquals(func.compute(5), 5);
        assertEquals(func.compute(6), 8);
    }

    @Test
    public void testFibonacciRecursively() throws Exception {
        FibonacciFunction func = Fibonacci::fibonacciRecursively;
        assertFibonacci(func);
    }

    @Test
    public void testFibonacciDynamic() throws Exception {
        FibonacciFunction func = Fibonacci::fibonacciDynamic;
        assertFibonacci(func);
    }

    @Test
    public void testFibonacciFormula() throws Exception {
        FibonacciFunction func = Fibonacci::fibonacciFormula;
        assertFibonacci(func);
    }

    @FunctionalInterface
    public interface FibonacciFunction {
        int compute(int value);
    }
}