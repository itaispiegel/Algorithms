package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Itai on 29-Oct-15.
 */
public class GCDTest extends GCD {

    @Test
    public void testGcd() throws Exception {
        assertEquals(21, gcd(462, 1071));
        assertEquals(50, gcd(150, 50));
        assertEquals(14, gcd(42, 28));
    }

    @Test
    public void testLcm() throws Exception {
        assertEquals(42, lcm(21, 6));
        assertEquals(84, lcm(12, 14));
        assertEquals(33, lcm(11, 3));
    }
}