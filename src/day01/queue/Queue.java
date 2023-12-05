package day01.queue;

/**
 *  배열을 이용해서 숫자를 여러개 저장할 수 있게 변수 생성
 * 	배열에 직접 접근해서 숫자를 저장할 수 있으면 안되기 때문에 접근 제어자로 제어
 *
 * 	맨 앞에 데이터가 어디에 저장된건지 가리킬 front 변수 생성
 * 	다음 데이터가 어디에 저장될건지 가리킬 rear 변수 생성
 *
 * 	현재 저장된 데이터의 수를 저장할 num 변수 생성

 *   0) 생성자
 * 	크기를 전달받아서 해당 크기만큼 정수를 저장할 수 있는 배열 생성
 * 	front 및 rear는 0 을 저장
 *
 *   1) isEmpty
 * 	num가 0이면 true 반환
 * 	그렇지 않으면 false 반환
 *
 *   2) isFull
 * 	배열의 크기가 num랑 같으면 true 반환
 * 	그렇지 않으면 false 반환
 *
 *   4) enQueue
 * 	데이터를 저장하는 연산
 * 	저장할 숫자를 하나 전달받고
 * 	큐가 가득 찼으면 가득찼다고 출력
 * 	그렇지 않으면 현재 rear의 위치의 배열에 전달받은 숫자를 저장하고 rear 1증가 후 num 1 증가
 *
 *   5) deQueue
 * 	데이터를 삭제하는 연산
 * 	큐가 비어있으면 비어있음 이라고 출력
 * 	그렇지 않으면 현재 front의 위치의 배열의 값을 꺼내고 front 1증가 후 num 1 감소
 *
 *   6) display
 * 	큐에 저장된 모든 데이터를 출력하는 기능
 */

public class Queue {
    private int front;
    private int rear;
    private int size;
    private Object[] queue;

    private int num;    // 현재 저장된 데이터의 수를 저장할 num 변수

    public Queue(int size) {
        this.front = 0;
        this.rear = 0;
        this.num = 0;
        this.size = size;
        this.queue = new Object[size];
    }

    public boolean isEmpty() {
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.queue.length == num) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int newValue) {
        if (this.isFull()) {
            throw new IllegalStateException("queue가 가득찼습니다.");
        } else {
            this.queue[this.rear] = newValue;
            System.out.println("[" + this.queue[this.rear] + "] enQueue success");
            ++this.rear;
            ++this.num;

            this.rear %= this.queue.length;
            /*
                해당 큐의 길이보다 크거나 같은 index가 들어오면 나머지 연산자를 통해
                항상 큐의 길이보다 작도록 index를 유지한다.

                원형 큐 구현
                front와 rear가 원 안에서 회전
                ex.)
                rear = 4
                rear = 4 % 5 => rear = 4인데
                rear = 4 에서 ++rear를 하는 순간 rear = 5가 되고
                rear = 5 % 5 => rear = 0이 된다.

                그러면 먼저 들어온 queue의 값이 빠지면 앞 인덱스도 원형 큐로 구현되어 있기 때문에
                데이터를 삽입할 수 있다.
             */
        }
    }

    public void deQueue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("queue가 이미 비어있습니다.");
        } else {
            System.out.println("[" + this.queue[this.front] + "] deQueue success");
            this.queue[this.front] = null;
            ++this.front;
            --this.num;

            this.front %= this.queue.length;
            //  원형 큐 구현
            //  해당 큐의 길이보다 크거나 같은 index가 들어오면 나머지 연산자를 통해
            //  항상 큐의 길이보다 작도록 index를 유지한다.
        }
    }

    public void display() {
        for (int i = 0; i < this.queue.length; i++) {
            System.out.print("[" + this.queue[i] + "]");
        }
        System.out.println();
        System.out.println("Front: " + this.front);
        System.out.println("Rear: " + this.rear);
        System.out.println();
    }



}
