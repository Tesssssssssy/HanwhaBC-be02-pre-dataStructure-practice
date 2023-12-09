package day04.RedBlackTreeEx;

import day04.TreePrinter;

public class RedBlackNode implements TreePrinter.PrintableNode  {
    private static final int BLACK = 0;
    private static final int RED = 1;
    private int value;
    private int color;

    RedBlackNode left;
    RedBlackNode right;
    RedBlackNode parent;

    RedBlackNode(int value) {
        this.value = value;
        color = BLACK;

        left = null;
        right = null;
        parent = null;
    }

    RedBlackNode() {
        this(-1);
    }

    int getValue() {
        return value;
    }

    String getColor() {
        return color == RED ? "RED" : "BLACK";
    }

    void setColor(int color) {
        this.color = color;
    }

    @Override
    public TreePrinter.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        String c = color == 0? "검정":"빨강"; 
        return "["+value+"("+c+")]";
    }
}
