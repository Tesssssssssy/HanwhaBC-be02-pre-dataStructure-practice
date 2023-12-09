package day05.Astar;

public class Node implements Comparable<Node> {
    // 노드에 뭘 기억해놓고 있어야 하는지 생각하자.
    Integer f;
    Integer g;
    Integer h;

    Integer x;
    Integer y;

    // 노드를 기억할 수 있는 부모 변수 추가해야.
    Node parents;

    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Node() {

    }

    public Node(Integer x, Integer y, Node parents) {
        this.x = x;
        this.y = y;
        this.parents = parents;
    }

    @Override
    public int compareTo(Node node) {
        return (this.f > node.f) ? 1 : -1;
    }
}
