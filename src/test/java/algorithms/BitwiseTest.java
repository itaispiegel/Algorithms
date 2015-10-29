package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Itai on 29-Oct-15.
 */
public class BitwiseTest extends Bitwise {

    int[] arr;

    @Before
    public void setUp() throws Exception {
        arr = new int[]{11, 9, 12, 17};
    }

    @Test
    public void testSwap() throws Exception {
        int[] expected = {12, 9, 11, 17};

        int a = 0;
        int b = 2;

        swap(arr, a, b);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testIsPowerOf2() throws Exception {
        assertTrue(isPowerOf2(16));
        assertTrue(isPowerOf2(8192));
        assertTrue(!isPowerOf2(183));

        assertTrue(!isPowerOf2(-8));
    }
}