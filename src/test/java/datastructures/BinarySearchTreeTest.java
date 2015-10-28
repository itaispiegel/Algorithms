package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Itai on 28-Oct-15.
 */
public class BinarySearchTreeTest {

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree(50, 25, 30, 15, 75, 85);
    }

    @Test
    public void testAddNode() throws Exception {

    }

    @Test
    public void testInOrderTraversal() throws Exception {
        System.out.print("\nIn Order Traversal: ");
        tree.inOrderTraversal();
        System.out.println();
    }

    @Test
    public void testPreOrderTraversal() throws Exception {
        System.out.print("\nPre Order Traversal: ");
        tree.preOrderTraversal();
        System.out.println();
    }

    @Test
    public void testPostOrderTraversal() throws Exception {
        System.out.print("\nPost Order Traversal: ");
        tree.postOrderTraversal();
        System.out.println();
    }

    @Test
    public void testFindNode() throws Exception {
        int requestedNode = 25;

        BinarySearchTree expectedNode = new BinarySearchTree(25, 15, 30);
        TreeNode actualNode = tree.findNode(requestedNode);

        assertEquals(actualNode, expectedNode.getRoot());
    }

    @Test
    public void testRemoveNode() throws Exception {
        tree.remove(50);
        System.out.println(tree);
    }
}