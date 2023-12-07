package day02.BTreeVer2;

public class BTree {
    static BTreeNode root = null;

    public static BTreeNode init() {
        BTreeNode np = new BTreeNode();
        np.leaf = true;
        np.n = 0;
        for (int i = 0; i < 3; i++) {
            np.childPtr[i] = null;
        }
        return np;
    }

    public static void traverse() {
        if (root != null) {
            traverse(root, 0);
        }
    }

    private static void traverse(BTreeNode p, int level) {
        if (p != null) {
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < p.n; i++) {
                System.out.print(p.data[i] + " ");
            }
            System.out.println();

            level++;
            for (int i = 0; i <= p.n; i++) {
                traverse(p.childPtr[i], level);
            }
        }
    }

    public static int splitChild(BTreeNode x, int i) {
        int j, mid;
        BTreeNode np1, np3, y;

        np3 = init();
        np3 = new BTreeNode(); // 수정된 부분
        np3.leaf = true;
        np3.n = 0;

        if (i == -1) {
            mid = x.data[1]; // 수정된 부분
            x.data[1] = 0;
            x.n--;
            np1 = init();
            np1.leaf = false;
            np1.data[0] = x.data[0]; // 수정된 부분
            np1.childPtr[0] = x.childPtr[0]; // 수정된 부분
            np1.childPtr[1] = np3;
            np1.n++;
            root = np1;
        } else {
            y = x.childPtr[i];
            mid = y.data[1]; // 수정된 부분
            y.data[1] = 0;
            y.n--;
            np3.data[0] = y.data[2]; // 수정된 부분
            np3.n++;
            y.data[2] = 0; // 수정된 부분
            y.n--;
            x.childPtr[1] = np3;
        }
        return mid;
    }

    public static void insert(int a) {
        root = insert(root, a);

        // Split root if it is full
        if (root.n == 3) {
            BTreeNode newRoot = init();
            newRoot.childPtr[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
    }

    public static BTreeNode insert(BTreeNode node, int key) {
        int i = node.n - 1;

        if (node.leaf) {
            while (i >= 0 && key < node.data[i]) {
                node.data[i + 1] = node.data[i];
                i--;
            }
            node.data[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && key < node.data[i]) {
                i--;
            }
            i++;

            if (node.childPtr[i] == null) {
                node.childPtr[i] = init();
            }

            if (node.childPtr[i].n == 3) {
                splitChild(node, i);
                if (key > node.data[i]) {
                    i++;
                }
            }
            node.childPtr[i] = insert(node.childPtr[i], key);
        }

        return node;
    }
}