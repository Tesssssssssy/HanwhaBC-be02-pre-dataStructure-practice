package day05.Astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Astar {
    // 초기화할 때 map 정보 전달받아서 출발지와 목적지의 좌표를 저장
    // 생성자를 통해 map 정보를 전달 받는다.
    // 출발지, 목적지를 이 때 기억해놔야 함.
    final Integer DEFAULT_COST = 10;
    final Integer DEFAULT_DIAGONAL_COST = 14;

    // 맵의 크기 저장 변수
    Integer mapX;
    Integer mapY;

    // 열린 목록 저장할 변수
    List<Node> openNodes;

    // 닫힌 목록 저장할 변수
    List<Node> closedNodes;

    // 초기화할 때 맵 정보를 전달 받아서 출발지와 목적지의 좌표를 변수에 저장
    Integer[][] map;

    Node start;

    Node goal;

    public Astar(Integer[][] map) {
        this.map = map;
        this.openNodes = new ArrayList<Node>();
        this.closedNodes = new ArrayList<Node>();

        // 맵 크기 초기화
        this.mapX = map.length;
        this.mapY = map[0].length;

        // 출발지, 도착지 초기화
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    System.out.println("x좌표 : " + j + ", y좌표 : " + i);
                    this.start = new Node(j, i);
                } else if (map[i][j] == 2) {
                    System.out.println("x좌표 : " + j + ", y좌표 : " + i);
                    this.goal = new Node(j, i);
                }
            }
        }
    }

    /*
        길 찾기 메소드
        열린 목록, 닫힌 목록 만들어야 함.
        열린 목록, 닫힌 목록을 findPath에서 정의하면 findPath에서 모든 기능을 다 구현해야 함.
        나중에 인접 노드 추가하는 기능을 다른 메소드로 뺄 거니까 그냥 밖에서 빼자.
    */
    public void findPath() {
        // 시작점을 열린 목록에 넣는다.
        openNodes.add(this.start);

        // 열린 목록이 비어 있지 않으면 반복
        // 리스트가 비어 있는지 아닌지 확인은 리스트변수.isEmpty() 사용
        while (!openNodes.isEmpty()) {
            // 열린 목록에서 제일 처음 노드를 가져온다. (미리 정렬하고)
            // F값이 가장 적은 하나를 가져온다(가져온 노드는 목록에서 삭제)
            Node minFNode = Collections.min(openNodes);
            openNodes.remove(minFNode);

            // 가져온 노드는 닫힌 목록에 넣어준다.
            closedNodes.add(minFNode);

            // 만약 가져온 노드가 최종 목적지면
            if (goal.equals(minFNode)) {
                // 최종 경로 출력
                printPath(start);
                return;
            }
            else {  // 그렇지 않으면
                addAdjacentNodes(minFNode);
            }
        }
        System.out.println("경로를 찾지 못했습니다.");
    }

    public void printPath(Node node) {
        // 최종 경로 출력하는 메소드
        // 특정 노드를 하나 전달받아서
        // 부모 부모 부모 찾아가서 출발지가 나오면
        // 출발지부터 출력

        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        Collections.reverse(path);

        for (Node pathNode : path) {
            System.out.println("x: " + pathNode.x + ", y: " + pathNode.y);
        }
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < mapX && y >= 0 && y < mapY && map[y][x] != 3;
    }

    // 열린 노드에 추가 시 안되게 해야!!
    private boolean isDuplicate(Node adjacentNode) {
        for (Node node : openNodes) {
            if (node!= null && node.x.equals(adjacentNode.x) && node.y.equals(adjacentNode.y)) {
                return true;
            }
        }

        for (Node node : closedNodes) {
            if (node!= null && node.x.equals(adjacentNode.x) && node.y.equals(adjacentNode.y)) {
                return true;
            }
        }

        return false;
    }


    public void addAdjacentNodes(Node currentNode) {
        // 인접하는 노드를 열린 목록에 추가하는 메소드
        // 전달받은 노드의 x, y 좌표를 따로 저장

        /*
            가야하는 노드들을 배열로 만들어서 반복해서 하나씩 가게 한다.
            인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
            생성한 노드의 f, g, h를 계산 후 각 변수에 저장
        */


        // 만약 isDuplicate 실행 결과 false이면
        // 생성한 노드를 열린 목록에 넣는다. (중복이 아니라는 거니까)
        // 넣고 정렬 (f값을 기준으로 오름차순 정렬)

        int currentX = currentNode.x;
        int currentY = currentNode.y;

        if (currentNode == null) {
            System.out.println("Error: currentNode is null");
            return;
        }

        int[] adjacentX = {currentX - 1, currentX, currentX + 1, currentX};
        int[] adjacentY = {currentY - 1, currentY, currentY + 1, currentY};

        for (int i = 0; i < 4; i++) {
            int nextX = adjacentX[i];
            int nextY = adjacentY[i];

            if (nextX < 0 || nextX >= mapX || nextY < 0 || nextY >= mapY) {
                continue;
            }

            if (map[nextY][nextX] != 0) {
                continue;
            }

            Node adjacentNode = new Node(nextX, nextY);
            adjacentNode.g = currentNode.g + DEFAULT_COST;

            if (i == 0 || i == 3) {
                adjacentNode.g += DEFAULT_COST;
            } else if (i == 1 || i == 2) {
                adjacentNode.g += DEFAULT_DIAGONAL_COST;
            }

            if (adjacentNode == null) {
                System.out.println("Error: adjacentNode is null");
                continue;
            }

            adjacentNode.h = calculateHeuristicValue(nextX, nextY);
            adjacentNode.f = adjacentNode.g + adjacentNode.h;
            adjacentNode.parent = currentNode;

            if (!isDuplicate(adjacentNode)) {
                openNodes.add(adjacentNode);
            }
        }
    }

    private int calculateHeuristicValue(int nextX, int nextY) {
        if (goal == null || goal.x == null || goal.y == null) {
            throw new NullPointerException("Goal node or its coordinates are not initialized.");
        }

        int dx = goal.x - nextX;
        int dy = goal.y - nextY;

        return Math.abs(dx) + Math.abs(dy);
    }
}
