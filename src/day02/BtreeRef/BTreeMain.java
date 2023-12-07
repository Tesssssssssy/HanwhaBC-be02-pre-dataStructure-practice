package day02.BtreeRef;

public class BTreeMain {
    public static void main(String[] args) {
        BTree bTree = new BTree(3);
        BTree bTree2 = new BTree(3);

        int[] keys = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        for (int key : keys) {
            bTree.insert(key);
        }
        bTree.print();
        System.out.println();
        System.out.println();

        int[] keys2 = {1, 4, 5, 11, 14, 15, 16, 17, 19, 22, 23, 26, 28, 34, 10, 21};

        for (int key : keys2) {
            bTree2.insert(key);
        }
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
