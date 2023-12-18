package day05.AstarMyVer;

public class Node {
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
        this.f=0;
        this.g=0;
        this.h=0;
    }

    public Node(Integer x, Integer y, Integer f, Integer g, Integer h, Node parents) {
        this.x = x;
        this.y = y;
        this.f = f;
        this.g = g;
        this.h = h;
        this.parents = parents;
    }
}
