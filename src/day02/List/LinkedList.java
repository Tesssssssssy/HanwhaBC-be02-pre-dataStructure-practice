package day02.List;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public void insertFirst(Integer input) {                // head의 앞 쪽에 새로운 노드 추가
        Node newNode = new Node(input, null);          // 새로운 노드 생성
        newNode.next = head;                                // 새로운 노드의 next가 기존 head를 가리키게 한다.
        head = newNode;                                     // head를 새로운 노드로 갱신.
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("이미 node가 비어 있습니다.");
        } else {
            Node temp = head;
            System.out.println("첫 번째 index " + temp.data + " 데이터가 삭제되었습니다.");
            head = head.next;
            temp = null;

        /*
            <선생님 버전>
            Node temp = head.next;
            head.next = null;
            head = temp;
        */
        }
    }

    public void insertLast(Integer input) {
        if (head == null) {
            this.insertFirst(input);
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            Node newNode = new Node(input, null);
            tempNode.next = newNode;
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("이미 node가 비어 있습니다.");
        } else {
            Node temp = head;
            Node preNode = null;
            while (temp.next != null) {
                preNode = temp;
                temp = temp.next;
            }
            System.out.println("마지막 index " + temp.data + " 데이터가 삭제되었습니다.");
            preNode.next = null;
        }
    }

    public void insertIndex(Integer index, Integer input) {
        if (head == null || index == 0) {
            this.insertFirst(input);
        } else {
            Node tempNode = head;
            Integer intTemp = 0;
//            while (tempNode.next != null) {
//                tempNode = tempNode.next;
//                intTemp += 1;
//            }
//            위 코드로 실행 시 끝까지 가버림.
//            특정 index에서 멈춰줘야 한다.

//            while (intTemp != index) {
//                tempNode = tempNode.next;
//                intTemp += 1;
//            }  이 while문으로 실행 시 3번 인덱스가 아니라 4번 인덱스에 저장됨
//               tempNode에 head를 넣어놓기 때문에.

            while (intTemp != index - 1) {
                tempNode = tempNode.next;
                intTemp += 1;
            }

            Node newNode = new Node(input, null);
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }
    }

    public void removeIndex(Integer index) {
        if (index == 0) {
            this.removeFirst();
        } else if (head != null) {
            Node temp = head;       // 변수 1
            Integer cnt = 0;    // 변수 2
            Node preNode = null;      // 변수 3

            while (cnt != index) {
                preNode = temp;
                temp = temp.next;
                cnt += 1;
            }
            /*
                내가 index 2를 입력했다면
                temp에 2번 인덱스 노드가 들어가고
                preNode에 1번 인덱스 노드가 들어간다.
            */
            System.out.println(index + " index " + temp.data + " 데이터가 삭제되었습니다.");
            preNode.next = temp.next;
            temp.next = null;
        }
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print("[" + node.data + "]");
            node = node.next;
        }
        System.out.println();
    }
}
