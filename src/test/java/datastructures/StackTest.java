package datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 27-Oct-15.
 */
public class StackTest extends Stack {

    private Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();

        //Load stack with {0, 1, 2, 3, 4}
        IntStream.range(0, 5).forEach(stack::push);
    }

    @Test
    public void testPush() throws Exception {
        int val = 16;

        stack.push(val);

        String expected = "16 4 3 2 1 0";
        assertEquals(stack.toString(), expected);
    }

    @Test
    public void testSize() throws Exception {
        int expected = 5;
        assertEquals(stack.size(), expected);
    }

    @Test
    public void testPop() throws Exception {
        Integer popExpected = 4;
        int sizeExpected = 4;

        Stack<Integer> stackExpected = new Stack<>();
        IntStream.range(0, 4).forEach(stackExpected::push);

        assertEquals(stack.pop(), popExpected);
        assertEquals(stack.size(), sizeExpected);
        assertEquals(stack.toString(), stackExpected.toString());
    }

    @Test
    public void testPeek() throws Exception {
        Integer expected = 4;
        assertEquals(stack.peek(), expected);
    }

    @Test
    public void testToString() throws Exception {
        String val = stack.toString();
        String expected = "4 3 2 1 0";

        assertEquals(val, expected);
    }
}
