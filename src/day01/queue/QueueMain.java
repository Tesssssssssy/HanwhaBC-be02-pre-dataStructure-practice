package day01.queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.display();

        queue.enQueue(1);
        queue.display();
        queue.enQueue(2);
        queue.display();
        queue.enQueue(3);
        queue.display();
        queue.enQueue(4);
        queue.display();
        queue.enQueue(5);
        queue.display();

        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();

        queue.enQueue(10);
        queue.display();
        queue.enQueue(11);
        queue.display();

        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();
        queue.deQueue();
        queue.display();

    }
}
