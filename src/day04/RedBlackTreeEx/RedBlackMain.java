package day04.RedBlackTreeEx;

import day04.TreePrinter;

public class RedBlackMain {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(8);
        rbt.insert(18);
        rbt.insert(5);
        rbt.insert(15);
        rbt.insert(17);
        rbt.insert(25);
        rbt.insert(40);

        TreePrinter.print(rbt.root);


    }
}
