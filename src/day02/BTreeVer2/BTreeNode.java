package day02.BTreeVer2;

class BTreeNode {
    int[] data;
    BTreeNode[] childPtr;
    boolean leaf;
    int n;

    static int M = 3; // 수정된 부분

    public BTreeNode() {
        this.data = new int[M - 1];
        this.childPtr = new BTreeNode[M]; // 수정된 부분
        this.leaf = true;
        this.n = 0;
    }
}

