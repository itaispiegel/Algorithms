package datastructures;

/**
 * Created by Itai on 31-Oct-15.
 */
public class RedBlackNode {

    private int value;

    private RedBlackNode parentNode;
    private RedBlackNode leftChild;
    private RedBlackNode rightChild;

    private int numLeft;
    private int numRight;

    private Color color;

    public enum Color {
        RED, BLACK
    }

    public RedBlackNode() {
        this.color = Color.BLACK;
        this.parentNode = null;
        this.leftChild = null;
        this.rightChild = null;

        this.numLeft = 0;
        this.numRight = 0;
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
        leftChild.setParentNode(this);

        this.leftChild = leftChild;
        this.numLeft++;
    }

    public RedBlackNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode rightChild) {
        rightChild.setParentNode(this);

        this.rightChild = rightChild;
        this.numRight++;
    }

    public int getNumLeft() {
        return numLeft;
    }

    public void setNumLeft(int numLeft) {
        this.numLeft = numLeft;
    }

    public int getNumRight() {
        return numRight;
    }

    public void setNumRight(int numRight) {
        this.numRight = numRight;
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
}
