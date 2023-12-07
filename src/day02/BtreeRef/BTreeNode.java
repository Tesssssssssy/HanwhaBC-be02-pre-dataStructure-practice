package day02.BtreeRef;

import java.util.ArrayList;

public class BTreeNode {
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> children;

    BTreeNode() {
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void print() {
        for (int key : keys) {
            System.out.print(key + " ");
        }
        System.out.println();
    }
}
