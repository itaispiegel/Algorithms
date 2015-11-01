package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 01-Nov-15.
 */
public class FibonacciTest extends Fibonacci {

    @Test
    public void testFibonacciRecursively() throws Exception {
        assertEquals(fibonacciRecursively(4), 3);
        assertEquals(fibonacciRecursively(5), 5);
        assertEquals(fibonacciRecursively(6), 8);
    }

    @Test
    public void testFibonacciDynamic() throws Exception {
        assertEquals(fibonacciDynamic(4), 3);
        assertEquals(fibonacciDynamic(5), 5);
        assertEquals(fibonacciDynamic(6), 8);
    }

    @Test
    public void testFibonacciFormula() throws Exception {
        assertEquals(fibonacciFormula(4), 3);
        assertEquals(fibonacciFormula(5), 5);
        assertEquals(fibonacciFormula(6), 8);
    }
}