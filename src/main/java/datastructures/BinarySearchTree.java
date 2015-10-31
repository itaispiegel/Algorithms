package datastructures;

import java.util.Objects;

/**
 * Created by Itai on 28-Oct-15.
 */
public class BinarySearchTree {

    /**
     * The root node of the binary search tree.
     */
    private TreeNode root;

    /**
     * Initialize an empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Initialize a search tree with the values.
     */
    public BinarySearchTree(int... values) {
        insert(values);
    }

    public TreeNode getRoot() {
        return root;
    }

    /**
     * <b>Complexity: O(logn)</b>
     * <br/>Add a new node to the tree.
     * The tree will find the valid spot for the note.
     */
    public TreeNode insert(TreeNode currNode, TreeNode node) {
        if(currNode == null) {
            return node;
        } else if(node.getValue() < currNode.getValue()) {
            currNode.setLeftChild(insert(currNode.getLeftChild(), node));
        } else {
            currNode.setRightChild(insert(currNode.getRightChild(), node));
        }

        return currNode;
     }

    /**
     * {@link #insert(TreeNode, TreeNode)}
     */
    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        this.root = insert(this.root, newNode);
    }

    /**
     * Add an array of nodes to the tree.
     * The tree will find the valid spot for each node.
     */
    public void insert(int... values) {
        for (int val : values) {
            insert(val);
        }
    }

    /**
     * {@link #insert(int...)}
     */
    public void insert(TreeNode... nodes) {
        for (TreeNode node : nodes) {
            insert(this.root, node);
        }
    }

    /**
     * Print the tree in ascending order.
     * Recursion is used to go to one node and then go to its child nodes and so forth.
     */
    public void inOrderTraversal(TreeNode focusNode) {

        if (focusNode != null) {

            //Traverse the left node
            inOrderTraversal(focusNode.getLeftChild());

            //Visit the currently focused node
            System.out.print(focusNode.getValue() + " ");

            //Traverse the right node
            inOrderTraversal(focusNode.getRightChild());
        }
    }

    /**
     * Print the tree in ascending order.
     * Recursion is used to go to one node and then go to its child nodes and so forth.
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * Traverse the left side, then the right side.
     */
    public void preOrderTraversal(TreeNode focusNode) {

        if (focusNode != null) {

            //Visit the currently focused node
            System.out.print(focusNode.getValue() + " ");

            //Traverse the left node
            preOrderTraversal(focusNode.getLeftChild());

            //Traverse the right node
            preOrderTraversal(focusNode.getRightChild());
        }
    }

    /**
     * Traverse the left side, then the right side.
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void postOrderTraversal(TreeNode focusNode) {
        if (focusNode != null) {

            //Traverse the left node
            preOrderTraversal(focusNode.getLeftChild());

            //Traverse the right node
            preOrderTraversal(focusNode.getRightChild());

            //Visit the currently focused node
            System.out.print(focusNode.getValue() + " ");
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * Find a node in the tree.
     */
    public TreeNode findNode(TreeNode currNode, int value) {
        if(currNode.getValue() == value) {
            return currNode;
        } else if(value < currNode.getValue()) {
            return findNode(currNode.getLeftChild(), value);
        } else {
            return findNode(currNode.getRightChild(), value);
        }
    }

    /**
     * {@link #findNode(TreeNode, int)}
     */
    public TreeNode findNode(int value) {
        return findNode(this.root, value);
    }

    public TreeNode getReplacementNode(TreeNode replacedNode) {

        TreeNode replacementParent = replacedNode;
        TreeNode replacement = replacedNode;

        TreeNode focusNode = replacedNode.getRightChild();

        // While there are no more left children

        while (focusNode != null) {

            replacementParent = replacement;

            replacement = focusNode;

            focusNode = focusNode.getLeftChild();

        }

        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

        if (replacement != replacedNode.getRightChild()) {

            replacementParent.setLeftChild(replacedNode.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());

        }

        return replacement;

    }

    public boolean remove(int value) {
        TreeNode focusNode = root;
        TreeNode parent = root;

        boolean isItALeftChild = true;

        //Search for the requested node
        while (focusNode.getValue() != value) {
            parent = focusNode;

            //If the requested node is less than the focus node, shift to the left of the tree.
            if (value < focusNode.getValue()) {

                isItALeftChild = true;

                focusNode = parent.getLeftChild();
            } else {

                isItALeftChild = false;

                focusNode = parent.getRightChild();
            }

            // If there is no such node.
            if (focusNode == null) {
                return false;
            }
        }

        //If the node does not have children.
        if (focusNode.getLeftChild() == null && focusNode.getRightChild() == null) {

            // If focus node is the root.
            if (focusNode == root) {
                root = null;
            }

            // Delete the node if it's parent has not children.
            if (isItALeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }

        // If no right child
        else if (focusNode.getRightChild() == null) {

            //If the node is the root, and it has no right children, set the left child as the root.
            if (focusNode == root) {
                root = focusNode.getLeftChild();
            }

            //If the node is a left child and it has no right child, set the left child as the node.
            else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getLeftChild());
            }

            //If the node is a right child and it has no right child, set the right child as the node.
            else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        }

        // If no left child.
        else if (focusNode.getLeftChild() == null) {

            //If the node is the root, and it has no left children, set the right child as the root.
            if (focusNode == root) {
                root = focusNode.getRightChild();
            }

            //If the node is a left child and it has no left child, set the right child as the node.
            else if (isItALeftChild) {
                parent.setLeftChild(focusNode.getRightChild());
            }

            //If the node is a right child and it has no left child, set the left child as the node.
            else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        }

        // If the node has two children
        else {

            //Find a replacement node
            TreeNode replacement = getReplacementNode(focusNode);

            if (focusNode == root) {
                root = replacement;
            } else if (isItALeftChild) {
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }

            replacement.setLeftChild(focusNode.getLeftChild());
        }

        return true;
    }

    /**
     * Are two BinarySearchTrees equal?
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof BinarySearchTree &&
                (this == o || Objects.equals(this.toString(), o.toString()));
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
