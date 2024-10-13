package Labs.w2d4;

public class BSTTest {
//25, 20, 30, 28, 29, 15, 18, 23, 10, 35, 45, 33, 29
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(25);
        bst.insert(20);
        bst.insert(30);
        bst.insert(28);
        bst.insert(29);
        bst.insert(15);
        bst.insert(18);
        bst.insert(23);
        bst.insert(10);
        bst.insert(35);
        bst.insert(45);
        bst.insert(33);
        bst.insert(29);

//        bst.insert(28);
//        bst.insert(20);
//        bst.insert(30);
//        bst.insert(35);
//        bst.insert(23);
//        bst.insert(15);
//        bst.insert(29);

        bst.printInOrder();

        System.out.println("Count Nodes : " + bst.countNodes());
        System.out.println("Count Leaves : " + bst.countLeaves());

        bst.mirrorTree();
        bst.printInOrder();
    }
}
