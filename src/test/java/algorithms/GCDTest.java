package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Itai on 29-Oct-15.
 */
public class GCDTest extends GCD {

    @Test
    public void testGcd() throws Exception {
        int a = 462;
        int b = 1071;

        int expected = 21;
        int actual = gcd(a, b);

        assertEquals(expected, actual);
    }
}