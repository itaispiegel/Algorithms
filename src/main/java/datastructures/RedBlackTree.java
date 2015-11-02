package datastructures;

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

    //NOT FINISHED
    public void rightRotate(RedBlackNode root) {
        if(root.getParentNode() == null || root.getRightChild() == null) {
            return;
        }

        RedBlackNode originalGrandparent = root.getGrandparentNode();
        RedBlackNode originalParent = root.getParentNode();
        RedBlackNode originalRightChild = root.getRightChild();

        originalParent.setLeftChild(originalRightChild);
        root.setRightChild(originalParent);

        insert(originalGrandparent, root);
    }

    //NOT FINISHED
    public void leftRotate(RedBlackNode root) {
        if(root.getParentNode() == null || root.getLeftChild() == null) {
            return;
        }

        RedBlackNode originalGrandparent = root.getGrandparentNode();
        RedBlackNode originalParent = root.getParentNode();
        RedBlackNode originalLeftChild = root.getLeftChild();

        originalParent.setRightChild(originalLeftChild);
        root.setLeftChild(originalParent);

        insert(originalGrandparent, root);
    }
}
