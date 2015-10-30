package datastructures;

import java.util.stream.IntStream;

/**
 * Created by Itai on 14-Oct-15.
 */
public class DataStructuresTest {

    public static void main(String[] args) {

        //-----LinkedStack------
        LinkedStack<Integer> linkedStack = new LinkedStack<>();

        // Add random numbers to the linkedStack
        IntStream.range(0, 15).forEach(linkedStack::push);

        // Print the linkedStack
        System.out.println(linkedStack);

        System.out.println("Peek: " + linkedStack.peek() + "\n");
        System.out.println(linkedStack);

        linkedStack.pop();
        System.out.println(linkedStack);

        System.out.println("-------------\n");

        //-----LinkedQueue------
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();

        // Add random numbers to the linkedStack
        IntStream.range(0, 15).forEach(linkedQueue::enqueue);
        System.out.println(linkedQueue);
    }
}
