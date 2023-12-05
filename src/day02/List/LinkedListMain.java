package day02.List;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(40);
        linkedList.insertFirst(50);
        linkedList.insertFirst(60);
        System.out.println("insertFirst 실행>");
        linkedList.display();

        linkedList.insertLast(100);
        linkedList.insertLast(110);
        linkedList.insertLast(120);
        linkedList.insertLast(130);
        System.out.println("\ninsertLast 실행>");
        linkedList.display();

        linkedList.insertIndex(3, 1000);
        System.out.println("\ninsertIndex 실행>");
        linkedList.display();

        System.out.println("\nremoveFirst 실행>");
        linkedList.removeFirst();
        linkedList.display();

        System.out.println("\nremoveLast 실행>");
        linkedList.removeLast();
        linkedList.display();

        System.out.println("\nremoveIndex 실행>");
        linkedList.removeIndex(2);
        linkedList.display();

        System.out.println("\nremoveIndex 실행>");
        linkedList.removeIndex(1);
        linkedList.display();

        System.out.println("\nremoveFirst 실행>");
        linkedList.removeFirst();
        linkedList.display();
    }
}
