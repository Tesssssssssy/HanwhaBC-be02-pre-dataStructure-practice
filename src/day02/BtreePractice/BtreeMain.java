package day02.BtreePractice;

public class BtreeMain {
    public static void main(String[] args) {
        // Create B-Tree
        BTree tree = new BTree(3);
        System.out.println("After inserting 10 and 20");
        tree.insert(10);
        tree.insert(20);
        tree.display();
        System.out.println("After inserting 50 and 60");
        tree.insert(50);
        tree.insert(60);
        tree.display();
        System.out.println("After inserting 30 and 40");
        tree.insert(30);
        tree.insert(40);
        tree.display();
    }
}
