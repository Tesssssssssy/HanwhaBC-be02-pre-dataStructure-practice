package day05.AstarMyVer;

public class Node implements Comparable<Node> {
    // 노드에 뭘 기억해놓고 있어야 하는지 생각하자.
    Integer f;
    Integer g;
    Integer h;

    Integer x;
    Integer y;

    // 노드를 기억할 수 있는 부모 변수 추가해야.
    Node parent;

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Node() {

    }

    public Node(Integer x, Integer y, Node parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node node) {
        if (this.f == null || node.f == null) {
            throw new NullPointerException("Node's f value is null.");
        }
        return this.f.compareTo(node.f);
    }
}
