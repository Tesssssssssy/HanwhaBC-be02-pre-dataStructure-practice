package day01.stack;

/**
 *  2. 스택의 구현
 * 	배열을 이용해서 숫자를 여러개 저장할 수 있게 변수 생성
 * 	배열에 직접 접근해서 숫자를 저장할 수 있으면 안되기 때문에 접근 제어자로 제어
 * 	숫자를 어디까지 저장했는지 가리키는 변수 top 생성
 *
 *   0) 생성자
 * 	크기를 전달받아서 해당 크기만큼 정수를 저장할 수 있는 배열 생성
 * 	top에 -1 저장
 *
 *   1) isEmpty
 * 	스택에 값이 모두  비어있는지 확인
 * 	top이 -1이면 true를 반환
 * 	그렇지 않으면 false를 반환
 *
 *   2) isFull
 * 	스택에 값이 모두 저장되어 있는지 확인
 * 	top이 배열의 크기보다 1작으면 true 반환
 * 	그렇지 않으면 false를 반환
 *
 *   3) peek
 * 	제일 마지막에 저장된 값 확인
 * 	제일 마지막에 저장된 값을 반환
 *
 *   4) push
 * 	데이터를 저장하는 연산
 * 	저장할 데이터를 전달받고
 * 	스택이 가득차 있지 않으면
 * 	top을 1증가하고 해당 인덱스 번호의 배열에 데이터 저장
 *
 *   5) pop
 * 	데이터를 삭제하는 연산
 * 	top 인덱스 번호의 배열에 값을 꺼내고
 * 	top 인덱스 번호의 배열에 값을 비워주고
 * 	top을 1 감소
 *
 *   6) display
 * 	스택에 저장된 모든 데이터를 출력하는 기능
 */

public class Stack {
    private int top;
    private Integer[] stack;

    public Stack(int size) {
        this.top = -1;
        this.stack = new Integer[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.stack.length - this.top == 1) {
            return true;
        } else {
            return false;
        }
    }

    public Object peek() {
        return this.stack[this.top];
    }

    public void push(int data) {
        if (this.isFull()) {
            throw new IllegalStateException("stack이 가득찼습니다.");
        } else {
            System.out.println("top: " + this.top);
            ++this.top;
            System.out.println("(+1) top: " + this.top);
            this.stack[this.top] = data;
            System.out.println("[" + data + "] push success\n");

        }
    }

    public void pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException("stack이 이미 비어있습니다.");
        } else {
            this.stack[this.top] = null;
            System.out.println("top: " + this.top);
            --this.top;
            System.out.println("(-1) top: " + this.top);
            System.out.println("[" + this.stack[this.top] + "] pop success\n");
        }
    }

    public void display() {
        for (int i = 0; i < this.stack.length; i++) {
            System.out.print("[" + stack[i] + "]");
        }
        System.out.println();
        System.out.println();
    }
}
