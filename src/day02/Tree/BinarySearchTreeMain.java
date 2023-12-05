package day02.Tree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.add(10);
        binarySearchTree.add(20);
        binarySearchTree.add(15);
        binarySearchTree.add(30);
        binarySearchTree.add(40);
        binarySearchTree.add(5);

        binarySearchTree.descendingTraversal();
        binarySearchTree.ascendingTraversal();

        binarySearchTree.search(10);
        binarySearchTree.search(20);
        binarySearchTree.search(15);
        binarySearchTree.search(40);
        binarySearchTree.search(5);

        binarySearchTree.print2D();
        TreePrinter.print(binarySearchTree.root);
    }
}
