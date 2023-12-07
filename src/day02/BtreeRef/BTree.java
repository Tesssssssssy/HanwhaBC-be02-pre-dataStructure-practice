package day02.BtreeRef;

import java.util.ArrayList;

public class BTree {
    private BTreeNode root;
    private int degree;

    public BTree(int degree) {
        this.root = null;
        this.degree = degree;
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode();
            root.keys.add(key);
        } else {
            insertRecursive(root, key);
            if (root.keys.size() > degree - 1) {
                BTreeNode newRoot = new BTreeNode();
                newRoot.children.add(root);
                split(newRoot, 0);
                root = newRoot;
            }
        }
    }

    private void insertRecursive(BTreeNode node, int key) {
        int index = findInsertIndex(node, key);

        if (node.children.isEmpty()) {
            node.keys.add(index, key);
        } else {
            BTreeNode child = node.children.get(index);
            insertRecursive(child, key);

            if (child.keys.size() > degree - 1) {
                split(node, index);
            }
        }
    }

    private int findInsertIndex(BTreeNode node, int key) {
        int index = 0;
        while (index < node.keys.size() && key > node.keys.get(index)) {
            index++;
        }
        return index;
    }

    private void split(BTreeNode parentNode, int childIndex) {
        BTreeNode childNode = parentNode.children.get(childIndex);
        BTreeNode newChildNode = new BTreeNode();

        int middleIndex = childNode.keys.size() / 2;
        int middleKey = childNode.keys.get(middleIndex);
        parentNode.keys.add(childIndex, middleKey);

        newChildNode.keys.addAll(new ArrayList<>(childNode.keys.subList(middleIndex + 1, childNode.keys.size())));
        childNode.keys.subList(middleIndex, childNode.keys.size()).clear();

        if (!childNode.children.isEmpty()) {
            newChildNode.children.addAll(new ArrayList<>(childNode.children.subList(middleIndex + 1, childNode.children.size())));
            childNode.children.subList(middleIndex + 1, childNode.children.size()).clear();
        }
        parentNode.children.add(childIndex + 1, newChildNode);
    }

    public void print() {
        printRecursive(root, 0);
    }

    private void printRecursive(BTreeNode node, int level) {
        if (node != null) {
            for (int i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    printRecursive(node.children.get(i), level + 1);
                }

                for (int j = 0; j < level; j++) {
                    System.out.print("\t");
                }
                System.out.println(node.keys.get(i));
            }

            if (node.children.size() > node.keys.size()) {
                printRecursive(node.children.get(node.children.size() - 1), level + 1);
            }
        }
    }
}

