package datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Itai on 31-Oct-15.
 */
public class RedBlackTreeTest {

    private RedBlackTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new RedBlackTree(50, 31, 69, 57, 90, 99);
    }

    @Test
    public void testInsert() throws Exception {
        RedBlackNode newNode = new RedBlackNode(112);
        tree.insert(tree.getRoot().getRightChild().getRightChild(), newNode);
    }

    @Test
    public void testRotateRight() throws Exception {
        tree.rightRotate(tree.getRoot().getRightChild());
    }

    @Test
    public void testGetParentNode() throws Exception {
        RedBlackNode node = tree.getRoot().getRightChild();

        assertEquals(node.getParentNode(), tree.getRoot());
        assertNull(tree.getRoot().getGrandparentNode());
    }

    @Test
    public void testGetUncle() throws Exception {
    }

    @Test
    public void testRightRotate() throws Exception {
        RedBlackTree rightRotate = new RedBlackTree(99, 111, 90, 69, 75, 50);
        rightRotate.rightRotate(rightRotate.getRoot().getLeftChild().getLeftChild());
    }

    @Test
    public void testLeftRotate() throws Exception {
        tree.leftRotate(tree.getRoot().getRightChild());

        RedBlackTree rotated = new RedBlackTree(69, 50, 31, 57, 90, 99);
    }
}