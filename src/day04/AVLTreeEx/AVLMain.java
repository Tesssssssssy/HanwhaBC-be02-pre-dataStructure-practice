package day04.AVLTreeEx;

import day04.TreePrinter;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(25);
        avl.insert(9);
        avl.insert(45);
        avl.insert(55);
        avl.insert(49);

        TreePrinter.print(avl.root);

    }
}
