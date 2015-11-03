package datastructures;

import com.sun.istack.internal.Nullable;

import java.util.Objects;

/**
 * Created by Itai on 31-Oct-15.
 */
public class RedBlackNode {

    private int value;

    private RedBlackNode parentNode;
    private RedBlackNode leftChild;
    private RedBlackNode rightChild;

    private Color color;

    public enum Color {
        RED, BLACK
    }

    public RedBlackNode() {
        this.color = Color.BLACK;
        this.parentNode = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public RedBlackNode(int value) {
        super();
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public RedBlackNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(RedBlackNode parentNode) {
        this.parentNode = parentNode;
    }

    public RedBlackNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackNode leftChild) {
        if(leftChild != null) {
            leftChild.setParentNode(this);
        }

        this.leftChild = leftChild;
    }

    public RedBlackNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode rightChild) {
        if(rightChild != null) {
            rightChild.setParentNode(this);
        }

        this.rightChild = rightChild;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RedBlackNode getGrandparentNode() {

        if(getParentNode() == null) {
            return null;
        }

        return getParentNode().getParentNode();
    }

    public RedBlackNode getUncleNode() {

        RedBlackNode grandparent = getGrandparentNode();

        if (grandparent == null) {
            return null;
        }

        RedBlackNode parent = getParentNode();

        if (parent.isLeftChild()) {
            return grandparent.getRightChild();
        } else {
            return grandparent.getLeftChild();
        }
    }

    public boolean isLeftChild() {
        RedBlackNode parent = getParentNode();
        return parent != null && parent.getLeftChild() == this;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RedBlackNode &&
                (this == obj || Objects.equals(this.toString(), obj.toString()));
    }

    @Override
    public String toString() {
        return "RedBlackNode{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", color=" + color +
                '}';
    }
}
