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
    public void testInsert() throws Exception {
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
        tree.remove(25);
    }
}