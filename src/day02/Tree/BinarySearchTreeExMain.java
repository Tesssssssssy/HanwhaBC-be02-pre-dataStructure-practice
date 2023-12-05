package day02.Tree;

public class BinarySearchTreeExMain {
    public static void main(String[] args) {
        BinarySearchTreeEx bst = new BinarySearchTreeEx();

        bst.add(10);
        bst.add(20);
        bst.add(30);
        bst.add(15);
        bst.add(40);
        bst.add(5);

        bst.print2D();
        TreePrinter.print(bst.root);

        BinarySearchTreeEx bst2 = new BinarySearchTreeEx();
        bst2.add2(10);
        bst2.add2(20);
        bst2.add2(30);
        bst2.add2(15);
        bst2.add2(40);
        bst2.add2(5);

        bst2.print2D();
        TreePrinter.print(bst2.root);
    }
}
