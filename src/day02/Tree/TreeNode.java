package day02.Tree;

public class TreeNode implements TreePrinter.PrintableNode {
    Integer data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // TreePrinter interface의 함수 override
    @Override
    public TreePrinter.PrintableNode getLeft() {
        return this.left;
    }

    @Override
    public TreePrinter.PrintableNode getRight() {
        return this.right;
    }

    @Override
    public String getText() {
        return "[" + data + "]";
    }
}
/*
    data : 입력값 저장
    left : data 보다 작은 왼쪽 자식 노드
    right : data보다 큰 오른쪽 자식 노드

    생성자
        객체 생성 시 입력값을 data에 넣고 왼쪽, 오른쪽 자식 노드를 null로 초기화
*/
