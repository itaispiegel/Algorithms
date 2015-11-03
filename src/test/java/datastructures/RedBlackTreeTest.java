package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Itai on 31-Oct-15.
 */
public class RedBlackTreeTest {

    private RedBlackTree tree1;
    private RedBlackTree tree2;

    @Before
    public void setUp() throws Exception {
        tree1 = new RedBlackTree(10, 1, 50, 31, 69, 57, 90, 99);
        tree2 = new RedBlackTree(8, 4, 3, 5, 2, 1, 9);
    }

    @Test
    public void testInsert() throws Exception {
        RedBlackNode newNode = new RedBlackNode(112);
        tree1.insert(tree1.getRoot().getRightChild().getRightChild(), newNode);
    }

    @Test
    public void testGetParentNode() throws Exception {
        RedBlackNode node = tree1.getRoot().getRightChild(); //50
        RedBlackNode parent = node.getParentNode();

        assertEquals(parent, tree1.getRoot());
        assertNull(tree1.getRoot().getGrandparentNode());
    }

    @Test
    public void testGetUncle() throws Exception {
    }

    @Test
    public void testRotateLeft() throws Exception {
        RedBlackTree leftRotate = new RedBlackTree(10, 1, 69, 50, 57, 31, 90, 99);

        tree1.rotateLeft(tree1.getRoot().getRightChild().getRightChild());
        assertEquals(leftRotate, tree1);
    }

    @Test
    public void testRotateRight() throws Exception {
        RedBlackTree rightRotate = new RedBlackTree(4, 3, 2, 1, 8, 5, 9);

        tree2.rotateRight(tree2.getRoot().getLeftChild());
        assertEquals(rightRotate, tree2);
    }
}