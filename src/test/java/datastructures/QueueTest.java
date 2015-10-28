package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 27-Oct-15.
 */
public class QueueTest extends Queue {

    private Queue<Integer> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
        IntStream.range(0, 5).forEach(queue::push);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "0 1 2 3 4";
        String val = queue.toString();

        assertEquals(val, expected);
    }

    @Test
    public void testPush() throws Exception {
        int val = 16;
        int sizeExpected = 6;

        queue.push(val);

        String expectedString = "0 1 2 3 4 " + val;
        String queueString = queue.toString();

        assertEquals(queueString, expectedString);
        assertEquals(queue.size(), sizeExpected);
    }

    @Test
    public void testPop() throws Exception {
        Integer expected = 0;
        Integer val = queue.pop();

        Queue<Integer> expectedQueue = new Queue<>();
        IntStream.range(1, 5).forEach(expectedQueue::push);

        assertEquals(val, expected);
        assertEquals(queue.toString(), expectedQueue.toString());
    }
}
