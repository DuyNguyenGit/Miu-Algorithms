package Labs.w2d4;

public class BST {
    public static void main(String[] args) {
        BST bst = new BST();
        System.out.println("Find 50: " + bst.find(50));

        bst.insert(50);
        bst.insert(75);
        bst.insert(25);

        bst.insert(80);
        bst.insert(40);
        bst.insert(60);
        bst.insert(15);
        bst.insert(45);
        bst.insert(77);
        bst.insert(10);
        bst.insert(55);
        bst.insert(20);
        bst.insert(70);
        bst.insert(79);

        bst.printInOrder();

        System.out.println("Find 100: " + bst.find(100));
        System.out.println("Find 50: " + bst.find(50));
        System.out.println("Find 45: " + bst.find(45));
        System.out.println("Find 10: " + bst.find(10));
        System.out.println("Find 11: " + bst.find(11));
        System.out.println("Find 79: " + bst.find(79));

        System.out.println("Delete 79: " + bst.delete(79));
        System.out.println("Find 79: " + bst.find(79));
        bst.printInOrder();

    }

    private BinaryNode root;

    public BST() {
        root = null;
    }

    public void printInOrder() {
        System.out.println("In order:");
        this.printTreeInOrder(root);
        System.out.println();
    }

    private void printTreeInOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            System.out.print(root.getData() + ", ");
            return;
        }
        printTreeInOrder(root.getLeft());
        System.out.print(root.getData() + ", ");
        printTreeInOrder(root.getRight());
    }

    public void insert(Integer data) {
        this.root = insertTree(data, root);
    }

    private BinaryNode insertTree(Integer data, BinaryNode root) {
        if (root == null) {
            root = new BinaryNode(data);
            return root;
        }
        if (data < root.getData()) {
            root.setLeft(insertTree(data, root.getLeft()));
        } else if (data > root.getData()) {
            root.setRight(insertTree(data, root.getRight()));
        }
        return root;
    }

    public Integer find(Integer data) {
        return this.find(data, this.root) != null ? this.find(data, this.root).getData() : null;
    }

    private BinaryNode find(Integer data, BinaryNode root) {
        if (root == null) {
            return null;
        }
        if (data.equals(root.getData())) {
            return root;
        }
        if (data < root.getData()) {
            return find(data, root.getLeft());
        } else if (data > root.getData()) {
            return find(data, root.getRight());
        }
        return null;
    }

    public Integer delete(Integer data) {
        BinaryNode node = this.deleteNode(data, this.root, this.root);
        return node != null ? node.getData() : null;
    }

    private BinaryNode deleteNode(Integer data, BinaryNode current, BinaryNode parent) {
        if (current == null) {
            return null;
        }

        if (data < current.getData()) {
            return deleteNode(data, current.getLeft(), current);
        } else if (data > current.getData()) {
            return deleteNode(data, current.getRight(), current);
        } else {
            if (current.isLeaf()) {
                if (parent.getLeft() == current) {
                    parent.setLeft(null);
                } else if (parent.getRight() == current) {
                    parent.setRight(null);
                }
            } else if (current.hasOnlyLeftChild()) {
                parent.setLeft(current.getLeft());
            } else if (current.hasOnlyRightChild()) {
                parent.setRight(current.getRight());
            } else {
                BinaryNode successor = findSmallestInRightSubtree(current);
                current.setData(successor.getData());
            }
            return current;
        }
    }

    private BinaryNode findSmallestInRightSubtree(BinaryNode current) {
        BinaryNode node = current.getRight();
        BinaryNode parent = node;
        while (node.getLeft() != null) {
            parent = node;
            node = node.getLeft();
        }
        parent.setLeft(null);
        return node;
    }

    public int countNodes() {
        return countNodes(this.root);
    }

    public int countLeaves() {
        return countLeaves(this.root);
    }

    public int countLeaves(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        if (root.isLeaf()) {
            return 1;
        }
        return countLeaves(root.getLeft()) + countLeaves(root.getRight());
    }

    private int countNodes(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        if (root.isLeaf()) {
            return 1;
        }
        return countNodes(root.getLeft()) + 1 + countNodes(root.getRight());
    }

    public BinaryNode mirrorTree() {
        mirrorTree(this.root);
        return this.root;
    }

    public void mirrorTree(BinaryNode currentNode) {
        if (currentNode == null) {
            return;
        }
        swapSubtree(currentNode, currentNode.getLeft(), currentNode.getRight());
        mirrorTree(currentNode.getLeft());
        mirrorTree(currentNode.getRight());
    }

    private void swapSubtree(BinaryNode currentNode, BinaryNode left, BinaryNode right) {
        BinaryNode temp = left;
        currentNode.setLeft(right);
        currentNode.setRight(temp);
    }
}
