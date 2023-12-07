package day02.BTreeMyVer;

import java.util.ArrayList;

public class BTree {
    private BTreeNode root;
    private int degree;

    public BTree(int degree) {
        this.root = null;
        this.degree = degree;
    }

    public void add(int key) {
        if (root == null) {
            root = new BTreeNode();
            root.keys.add(key);
        } else {
            addRecur(root, key);
            if (root.keys.size() > degree - 1) {
                BTreeNode newRoot = new BTreeNode();
                newRoot.children.add(root);
                split(newRoot, 0);
                root = newRoot;
            }
        }
    }

    private void addRecur(BTreeNode node, int key) {
        int index = findAddIndex(node, key);

        if (node.children.isEmpty()) {
            node.keys.add(index, key);
        } else {
            BTreeNode child = node.children.get(index);
            addRecur(child, key);

            if (child.keys.size() > degree - 1) {
                split(node, index);
            }
        }
    }

    private int findAddIndex(BTreeNode node, int key) {
        int index = 0;
        while (index < node.keys.size() && key > node.keys.get(index)) {
            index++;
        }
        return index;
    }

    private void split(BTreeNode parentNode, int childIndex) {
        BTreeNode childNode = parentNode.children.get(childIndex);
        BTreeNode newChildNode = new BTreeNode();

        int middleIndex = childNode.keys.size() / 2;
        int middleKey = childNode.keys.get(middleIndex);
        parentNode.keys.add(childIndex, middleKey);

        newChildNode.keys.addAll(new ArrayList<>(childNode.keys.subList(middleIndex + 1, childNode.keys.size())));
        childNode.keys.subList(middleIndex, childNode.keys.size()).clear();

        if (!childNode.children.isEmpty()) {
            newChildNode.children.addAll(new ArrayList<>(childNode.children.subList(middleIndex + 1, childNode.children.size())));
            childNode.children.subList(middleIndex + 1, childNode.children.size()).clear();
        }
        parentNode.children.add(childIndex + 1, newChildNode);
    }

    public void print() {
        printRecursive(root, 0);
    }

    private void printRecursive(BTreeNode node, int level) {
        if (node != null) {
            for (int i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    printRecursive(node.children.get(i), level + 1);
                }

                for (int j = 0; j < level; j++) {
                    System.out.print("\t");
                }
                System.out.println(node.keys.get(i));
            }

            if (node.children.size() > node.keys.size()) {
                printRecursive(node.children.get(node.children.size() - 1), level + 1);
            }
        }
    }
}

/*
    TreeNode - BTree의 노드 정의
    - keys : 노드의 key들을 저장하는 리스트
             key 삽입 메소드에서 차수 - 1 보다 key 개수가 많으면 분할 처리
    - children : 자식 노드들을 저장하는 리스트
                 새로 노드 추가 후 children에 추가하는 방식


    Btree
    - root : BTree의 루트 노드 변수 선언
    - degree : BTree의 차수 변수 선언
    - 생성자
        - BTree 생성 시 차수 degree 값을 받아 BTree 객체 생성 (메인 함수에서 3으로 객체 생성 예정)
        - root : 노드를 null로 초기화
        - degree : 입력받은 degree로 생성자에서 초기화


    add 함수
     특정 key를 BTree에 삽입하는 메소드
        만약 루트 노드가 null이면 (없으면) root에 새로운 BTreeNode 객체 생성 후 저장
        root에 저장된 새 객체의 keys list에 입력값 key 저장
        만약 루트 노드가 null이 아니면
        addRecur 메소드 호출 (재귀적으로 삽입 수행)
     만약 root 노드의 key 개수가 2보다 많으면 (우리는 3차 트리이니까 노드의 data 개수 2개)
        BTreeNode 타입의 새로운 root 노드 객체 생성
        새로운 root 객체의 자식에 기존 root 추가
        새로운 root 객체와 기존 root가 저장된 children list의 0번 index와 split 함수 호출
        이제 root가 새로운 newRoot가 됨.


    addRecur 함수
      key를 적절한 자식 노드에 재귀적으로 삽입하는 메소드
      입력값이 들어갈 적절한 노드의 index를 찾는 findAddIndex 함수를 호출해 int index에 저장
      만약 param에서 받은 노드의 children list가 비어있으면
         그 노드의 키값들에 index와 key 저장
         (= 현재 노드가 리프 노드일 경우 key 추가하고 종료)
      그렇지 않으면 (현재 노드의 자식 노드 children이 비어있지 않으면 (리프 노드가 아니면))
         자식 노드로 이동하면서 재귀적으로 삽입 수행
        만약 자식 노드의 키 개수가 3-1=2보다 많으면 분할 (split 함수 호출)


    findAddRecur 함수
      addRecur 메소드에서 사용되는 메소드 (key를 노드에 삽입할 위치의 index를 찾는다.)
      int index의 default값은 0
         param으로 받은 node의 key 개수가 index 보다 크고 key값이 node의 key 리스트에서 index 위치의 값보다 크면
         index++
      while 문 탈출해서 index 반환


    split 함수
      부모 노드의 특정 자식 노드를 분할하는 메소드
      (중간 키를 부모 노드로 이동시키고 키와 자식 노들르 새로운 자식 (children) 노드로 이동)


    print 함수
       BTree의 출력 메소드


    printRecursive
       재귀적으로 BTree의 각 레벨을 출력하고 들여쓰기 추가

*/