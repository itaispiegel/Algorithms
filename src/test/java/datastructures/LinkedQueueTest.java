package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 27-Oct-15.
 */
public class LinkedQueueTest extends LinkedQueue {

    private LinkedQueue<Integer> linkedQueue;

    @Before
    public void setUp() throws Exception {
        linkedQueue = new LinkedQueue<>();
        IntStream.range(0, 5).forEach(linkedQueue::enqueue);
    }

    @Test
    public void testToString() throws Exception {
        String expected = "0 1 2 3 4";
        String val = linkedQueue.toString();

        assertEquals(val, expected);
    }

    @Test
    public void testPush() throws Exception {
        int val = 16;
        int sizeExpected = 6;

        linkedQueue.enqueue(val);

        String expectedString = "0 1 2 3 4 " + val;
        String queueString = linkedQueue.toString();

        assertEquals(queueString, expectedString);
        assertEquals(linkedQueue.size(), sizeExpected);
    }

    @Test
    public void testPop() throws Exception {
        Integer expected = 0;
        Integer val = linkedQueue.dequeue();

        LinkedQueue<Integer> expectedLinkedQueue = new LinkedQueue<>();
        IntStream.range(1, 5).forEach(expectedLinkedQueue::enqueue);

        assertEquals(val, expected);
        assertEquals(linkedQueue.toString(), expectedLinkedQueue.toString());
    }
}
