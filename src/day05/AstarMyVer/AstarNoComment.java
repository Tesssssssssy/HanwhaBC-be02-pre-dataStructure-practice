package day05.AstarMyVer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AstarNoComment {
    final Integer DEFAULT_COST = 10;
    final Integer DEFAULT_DIAGONAL_COST = 14;

    Integer mapX;
    Integer mapY;

    List<Node> openNodes;
    List<Node> closedNodes;

    Integer[][] map;
    Node start;
    Node goal;

    public AstarNoComment(Integer[][] map) {
        this.map = map;
        this.openNodes = new ArrayList<Node>();
        this.closedNodes = new ArrayList<Node>();

        this.mapX = map.length;
        this.mapY = map.length;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1) {
                    System.out.println("x좌표 : " + j + ", y좌표 : " + i);
                    this.start = new Node(j, i);
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 2) {
                    System.out.println("x좌표 : " + j + ", y좌표 : " + i);
                    this.goal = new Node(j, i);
                }
            }
        }
    }

    public void findPath() {
        openNodes.add(this.start);

        while (!openNodes.isEmpty()) {
            Node minFNode = Collections.min(openNodes);
            openNodes.remove(minFNode);

            closedNodes.add(minFNode);

            if (goal.equals(minFNode)) {
                printPath(start);
            }
            else {
                addAdjacentNodes(minFNode);
            }
        }
    }

    public void printPath(Node node) {
        // 최종 경로 출력하는 메소드
        // 특정 노드를 하나 전달받아서
        // 부모 부모 부모 찾아가서 출발지가 나오면
        // 출발지부터 출력
    }

    public boolean isDuplicate(Node adjacentNode) {
        for (Node openNode : openNodes) {
            if (openNode.x == adjacentNode.x && openNode.y == adjacentNode.y) {
                return true;
            }
        }
        for (Node openNode : closedNodes) {
            if (openNode.x == adjacentNode.x && openNode.y == adjacentNode.y) {
                return true;
            }
        }
        return false;
    }


    public void addAdjacentNodes(Node adjacentNode) {
        int adjacentNodeX = adjacentNode.x;
        int adjacentNodeY = adjacentNode.y;

        List<Node> adjacentNodes = new ArrayList<Node>();

        Node temp1 = new Node(adjacentNodeX - 1, adjacentNodeY - 1);    // 왼오 -> g = 14
        Node temp2 = new Node(adjacentNodeX - 1, adjacentNodeY);           // 왼 -> g = 10
        Node temp3 = new Node(adjacentNodeX - 1, adjacentNodeY + 1);    // 왼아 -> g = 14
        Node temp4 = new Node(adjacentNodeX, adjacentNodeY - 1);           // 위 -> g = 10
        Node temp5 = new Node(adjacentNodeX, adjacentNodeY + 1);           // 아 -> g = 10
        Node temp6 = new Node(adjacentNodeX + 1, adjacentNodeY - 1);    // 오위 -> g = 14
        Node temp7 = new Node(adjacentNodeX + 1, adjacentNodeY);           // 오 -> g = 10
        Node temp8 = new Node(adjacentNodeX + 1, adjacentNodeY + 1);    // 오아 -> g = 14

        adjacentNodes.add(temp1);
        adjacentNodes.add(temp2);
        adjacentNodes.add(temp3);
        adjacentNodes.add(temp4);
        adjacentNodes.add(temp5);
        adjacentNodes.add(temp6);
        adjacentNodes.add(temp7);
        adjacentNodes.add(temp8);

        // 가야하는 노드들을 배열로 만들어서 반복해서 하나씩 가게 한다.
        // 인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
        // 생성한 노드의 f, g, h를 계산 후 각 변수에 저장
        for (Node node : adjacentNodes) {
            int cnt = 0;
            if (node.x < mapX && node.y < mapY && !map.equals(3)) {
                ++cnt;
               /*
                        왼오 -> g = 14
                        왼 -> g = 10
                        왼아 -> g = 14
                        위 -> g = 10
                        아 -> g = 10
                        오위 -> g = 14
                        오 -> g = 10
                        오아 -> g = 14

                     1, 1 (왼위)      2, 1 (위)          3, 1 (오위)
                     1, 2 (왼)        2, 2 (시작)        3, 2 (오)
                     1, 3 (왼아)      2, 3 (아)          3, 3 (오아)

                     부모 노드 만들어야 하는데 어디에서..?

                */
                /*
                    node.g = cnt * DEFAULT_COST; ->
                    or
                    node.g = cnt * DEFAULT_DIAGONAL_COST;
                    node.h = ;
                    node.f = node.g + node.h;

                */
            }
        }
        // 새로운 노드 생성 (좌표, 부모 등을 전달해서)
        Node newNode = new Node();

        // 중복 체크 isDuplicate() 실행해서 결과 따로 저장
        boolean isDuplicate = isDuplicate(adjacentNode);

        // 만약 isDuplicate 실행 결과 false이면
        // 생성한 노드를 열린 목록에 넣는다. (중복이 아니라는 거니까)
        if (isDuplicate == false) {
            openNodes.add(newNode);
        }

        // 넣고 정렬 (f값을 기준으로 오름차순 정렬)
    }
}
