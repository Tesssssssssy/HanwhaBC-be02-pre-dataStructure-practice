package day02.Tree;

public class TreeNode implements TreePrinter.PrintableNode {
    // 육안으로 쉽게 트리의 구조를 확인하기 위한 TreePrinter interface implements.

    Integer data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // TreePrinter interface의 함수 implement.
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
