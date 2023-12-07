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

        binarySearchTree.inOrder();
        // 중위 순회 (왼쪽 자식 -> 부모 -> 오른쪽 자식 순으로 순회)

        binarySearchTree.preOrder();
        // 전위 순회 (부모 -> 왼쪽 자식 -> 오른쪽 자식 순으로 순회)

        binarySearchTree.postOrder();
        // 후위 순회 (왼쪽 자식 -> 오른쪽 자식 -> 부모 순으로 조회)

//        binarySearchTree.search(10);
//        binarySearchTree.search(20);

        binarySearchTree.print2D();
        TreePrinter.print(binarySearchTree.root);

        binarySearchTree.remove(10);
        TreePrinter.print(binarySearchTree.root);
    }
}
