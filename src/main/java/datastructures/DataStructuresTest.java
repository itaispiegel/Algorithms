package datastructures;

import java.util.stream.IntStream;

/**
 * Created by Itai on 14-Oct-15.
 */
public class DataStructuresTest {

    public static void main(String[] args) {

        //-----Stack------
        Stack<Integer> stack = new Stack<>();

        // Add random numbers to the stack
        IntStream.range(0, 15).forEach(stack::push);

        // Print the stack
        System.out.println(stack);

        System.out.println("Peek: " + stack.peek() + "\n");
        System.out.println(stack);

        stack.push(14);
        System.out.println(stack);

        System.out.println("-------------\n");

        //-----Queue------
        Queue<Integer> queue = new Queue<>();

        // Add random numbers to the stack
        IntStream.range(0, 15).forEach(queue::push);
        System.out.println(queue);
    }
}
