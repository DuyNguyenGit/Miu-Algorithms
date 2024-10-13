package Labs.w2d4;

public class BinaryNode {
    private Integer data;
    private BinaryNode left;
    private BinaryNode right;

    public BinaryNode(Integer data) {
        this(data, null, null);
    }

    public BinaryNode(Integer data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasTwoChildren() {
        return left != null && right != null;
    }

    public boolean hasOnlyOneChild() {
        return !isLeaf() && !hasTwoChildren();
    }

    public boolean hasOnlyLeftChild() {
        return hasOnlyOneChild() && left != null;
    }

    public boolean hasOnlyRightChild() {
        return hasOnlyOneChild() && right != null;
    }
}
