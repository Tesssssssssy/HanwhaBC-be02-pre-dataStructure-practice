package day02.BtreePractice;

import day02.Tree.TreeNode;

public class BTree {

    static final int COUNT = 10;

    // Root of B-Tree
    private BTreeNode root;
    // Minimum degree
    private int t;
    // Constructor

    public BTree(int t) {
        this.root = new BTreeNode(t, true);
        this.t = t;
    }

    // Function to insert a node in the B-Tree
    public void insert(int key) {
        BTreeNode[] newEntry = {null};
        int[] val = {0};
        // Insert in B-Tree
        root.insert(key, val, newEntry);
        // If newEntry is not null then root needs to be
        // split. Create new root
        if (newEntry[0] != null) {
            root = root.makeNewRoot(val[0], newEntry[0]);
        }
    }

    // Prints BTree
    public void display() {
        root.traverse(0);
    }
}
