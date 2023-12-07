package day02.BTreeMyVer;

import java.util.ArrayList;

public class BTreeNode {
    ArrayList<Integer> keys;
    ArrayList<BTreeNode> children;

    public BTreeNode() {
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }
}
