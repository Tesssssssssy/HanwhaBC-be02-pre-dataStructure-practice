package day01.stack;

public class StackEx {
    // 변수
    private Integer[] data;
    private Integer top;

    // 메소드
    public StackEx(Integer size) {
        this.data = new Integer[size];
        this.top = -1;
    }

    public Boolean isEmpty() {
        if(this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isFull() {
        if(this.top == this.data.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Integer peek() {
        return this.data[this.top];
    }

    public void push(Integer data) {
        if(this.isFull()){
            System.out.println("스택이 가득참");
        } else {
            this.top = this.top + 1;
            this.data[this.top] = data;
        }
    }

    public Integer pop() {
        Integer data = null;
        if(this.isEmpty()){
            System.out.println("스택이 비어있음");
        } else {
            data = this.data[this.top];
            this.data[this.top] = null;
            this.top = this.top - 1;
        }

        return data;
    }

    public void display() {
        for (int i = 0; i < this.data.length; i++) {
            System.out.print("["+this.data[i]+"]");
        }
        System.out.println();
    }

}