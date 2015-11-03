package datastructures;

import java.util.Objects;

/**
 * Created by Itai on 31-Oct-15.
 */
public class RedBlackTree {

    private RedBlackNode root;

    public RedBlackTree() {
        root = null;
    }

    public RedBlackTree(int... vals) {
        this();
        insert(vals);
    }

    public RedBlackNode getRoot() {
        return root;
    }

    public void setRoot(RedBlackNode root) {
        this.root = root;
    }

    /**
     * <b>Complexity: O(logn)</b>
     * <br/>Add a new node to the tree.
     * The tree will find the valid spot for the note.
     */
    @SuppressWarnings("Duplicates")
    public RedBlackNode insert(RedBlackNode currNode, RedBlackNode node) {
        if(currNode == null) {
            return node;
        } else if(node.getValue() < currNode.getValue()) {
            currNode.setLeftChild(insert(currNode.getLeftChild(), node));
        } else {
            currNode.setRightChild(insert(currNode.getRightChild(), node));
        }

        return currNode;
    }

    public void insert(int... vals) {
        for(int val : vals) {
            insert(val);
        }
    }

    public void insert(int val) {
        RedBlackNode newNode = new RedBlackNode(val);
        this.root = insert(root, newNode);
    }

    //Not fully checked
    /**
     * Rotate tree right at sub-tree rooted at node.
     */
    protected void rotateRight(RedBlackNode node) {
        RedBlackNode parent = node.getParentNode();
        RedBlackNode grandparent = node.getGrandparentNode();

        if(parent == null) {
            return;
        }

        parent.setRightChild(node.getLeftChild());

        node.setLeftChild(parent);
        node.setParentNode(grandparent);

        if(grandparent != null) {
            grandparent.setRightChild(node);
        }

        while(node.getParentNode() != null) {
            node = node.getParentNode();
        }

        this.root = node;
    }

    //NOT FINISHED
    public void leftRotate(RedBlackNode node) {
        RedBlackNode parent = node.getParentNode();
        RedBlackNode grandparent = node.getGrandparentNode();

        if(parent == null) {
            return;
        }

        parent.setLeftChild(node.getRightChild());

        node.setRightChild(parent);
        node.setParentNode(grandparent);

        if(grandparent != null) {
            grandparent.setLeftChild(node);
        }

        while(node.getParentNode() != null) {
            node = node.getParentNode();
        }

        this.root = node;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RedBlackTree &&
                (this == obj || Objects.equals(this.toString(), obj.toString()));
    }

    @Override
    public String toString() {
        return "RedBlackTree{" +
                "root=" + root +
                '}';
    }
}
