package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 27-Oct-15.
 */
public class LinkedStackTest extends LinkedStack {

    private LinkedStack<Integer> linkedStack;

    @Before
    public void setUp() throws Exception {
        linkedStack = new LinkedStack<>();

        //Load linkedStack with {0, 1, 2, 3, 4}
        IntStream.range(0, 5).forEach(linkedStack::push);
    }

    @Test
    public void testPush() throws Exception {
        int val = 16;

        linkedStack.push(val);

        String expected = "16 4 3 2 1 0";
        assertEquals(linkedStack.toString(), expected);
    }

    @Test
    public void testSize() throws Exception {
        int expected = 5;
        assertEquals(linkedStack.size(), expected);
    }

    @Test
    public void testPop() throws Exception {
        Integer popExpected = 4;
        int sizeExpected = 4;

        LinkedStack<Integer> linkedStackExpected = new LinkedStack<>();
        IntStream.range(0, 4).forEach(linkedStackExpected::push);

        assertEquals(linkedStack.pop(), popExpected);
        assertEquals(linkedStack.size(), sizeExpected);
        assertEquals(linkedStack.toString(), linkedStackExpected.toString());
    }

    @Test
    public void testPeek() throws Exception {
        Integer expected = 4;
        assertEquals(linkedStack.peek(), expected);
    }

    @Test
    public void testToString() throws Exception {
        String val = linkedStack.toString();
        String expected = "4 3 2 1 0";

        assertEquals(val, expected);
    }
}
