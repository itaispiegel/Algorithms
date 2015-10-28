package datastructures;

import java.util.Objects;

/**
 * Created by Itai on 28-Oct-15.
 */
public class TreeNode {

    private int value;

    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode() {
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || Objects.equals(this.toString(), o.toString());
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
