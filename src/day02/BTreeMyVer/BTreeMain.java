package day02.BTreeMyVer;

public class BTreeMain {
    public static void main(String[] args) {
        BTree bTree = new BTree(3);
        BTree bTree2 = new BTree(3);

        int[] keys = {10, 20, 30, 40, 50, 60, 70};

        for (int key : keys) {
            bTree.add(key);
        }
        bTree.print();
        System.out.println();
        System.out.println();

        bTree2.print();
    }

    /*
                10
            20
                30
        40
                50
            60
                70
            80
                90
    */
}
