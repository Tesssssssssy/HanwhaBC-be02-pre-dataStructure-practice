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
        this.mapY = map.length;

        // 출발지 초기화
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 1) {
                    System.out.println("x좌표 : " + j + ", y좌표 : " + i);
                    this.start = new Node(j, i);
                }
            }
        }

        // 도착지 초기화
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 2) {
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
            }
            else {  // 그렇지 않으면
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

    // 열린 노드에 추가 시 안되게 해야!!
    public boolean isDuplicate(Node adjacentNode) {
        // 열린 노드에 있는 노드들을 하나씩 가져오면서 반복
        // 가져온 노드의 x, y와 전달받은 노드의 x, y가 같으면 중복
        for (Node openNode : openNodes) {
            if (openNode.x == adjacentNode.x && openNode.y == adjacentNode.y) {
                return true;
            }
        }

        // 닫힌 노드에 있는 노드들도 하나씩 중복 체크
        for (Node openNode : closedNodes) {
            if (openNode.x == adjacentNode.x && openNode.y == adjacentNode.y) {
                return true;
            }
        }
        return false;
    }


    public void addAdjacentNodes(Node adjacentNode) {
        // 인접하는 노드를 열린 목록에 추가하는 메소드

        // 전달받은 노드의 x, y 좌표를 따로 저장
        int adjacentNodeX = adjacentNode.x;
        int adjacentNodeY = adjacentNode.y;

        /* 왼위, 위, 오위, 왼, 오, 왼아, 아, 오아
             1, 1 (왼위)      2, 1 (위)          3, 1 (오위)
             1, 2 (왼)        2, 2 (시작)        3, 2 (오)
             1, 3 (왼아)      2, 3 (아)          3, 3 (오아)
        */

        // 반복문 나중에 수정하자.
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
