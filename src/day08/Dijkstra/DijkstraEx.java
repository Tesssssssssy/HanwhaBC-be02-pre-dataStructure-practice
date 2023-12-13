package day08.Dijkstra;

import java.util.Arrays;
import java.util.Collections;

public class DijkstraEx {
    static final int INF = 10000;
    boolean[] visited;
    int[] costs;
    int[] path;

    public void findPath(int N, int[][] graph) {
        visited = new boolean[N];
        costs = new int[N];
        path = new int[N];

        // visited = [T, F, F, F, F, F, F, F]
        // costs = [0, INF, INF, INF, INF, INF, INF, INF]
        // path = [0, 0, 0, 0, 0, 0, 0, 0]
        Arrays.fill(costs, INF);

        // 시작 노드를 0으로 설정
        // 시작 노드의 costs를 0으로 설정
        int startNode = 0;
        costs[startNode] = 0;

        for (int i = 0; i < N-1; i++) {
            // 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택한다.
            int minNode = findMinNode(costs, visited);

            // 선택한 노드를 방문 처리 -> minNode가 내가 현재 위치한 곳이 되는 것.
            visited[minNode] = true;

            // graph에서 하나를 가져와서 (숫자들이 저장되어 있는 배열 하나를 가져온다.)
            for (int[] edge : graph) {
                //     방문한 적 없고 출발지가 선택한 노드고 출발지의 비용이 INF가 아니고
                //     출발지의 비용 + 간선의 비용이 목적지의 비용보다 작으면
                //        (출발지가 어디이고 도착지가 어디이고 비용은 어떻게 되는지 어떻게 알 수 있을까)
                int from = 0;
                int to = 0;
                int cost = 0;
                /*
                    초기화되지 않으면 아래 if문이 실행되지 않을 수 있다.
                    초기화되지 않아서 아래 if문에서 에러 발생.
                */

                if (minNode == edge[0]) {
                    from = edge[0];
                    to = edge[1];
                    cost = edge[2];
                } else if (minNode == edge[1]) {
                    from = edge[1];
                    to = edge[0];
                    cost = edge[2];
                }

                /*
                        from = edge[0];
                        to = edge[1];
                        cost = edge[2];

                        2, 6, 2 와
                        6, 2, 2 를 똑같이 하고 싶을 때 어떻게 해야 할까?
                        위에 처럼 코드를 작성할 경우 테스트 코드에서 통과하지 못하고
                        두 상황을 똑같다고 인지하지 못한다.

                        그래서 2, 6, 2로 했을 때 2에 갈 수 없는 경우가 나와서 비용이 1000으로 나오게 된다. <에러>
                */

                if (!visited[to] && from == minNode && costs[from] + cost < costs[to]) {
                    // 비용 갱신
                    // 경로 갱신
                    costs[to] = costs[from] + cost;
                    path[to] = from;
                }
            }
        }
    }

    private int findMinNode(int[] costs, boolean[] visited) {
        int minCost = INF;
        int minNode = -1;

        for (int i = 0; i < costs.length; i++) {
            if (!visited[i] && costs[i] < minCost) {
                minCost = costs[i];
                minNode = i;
            }
        }
        return minNode;
    }


    public void printPath() {
        System.out.println("costs:");
        for (int i = 0; i < costs.length; i++) {
            System.out.println("To node " + i + ": " + costs[i]);
        }

        System.out.println("path:");
        for (int i = 0; i < path.length; i++) {
            System.out.println("To node " + i + ": " + path[i]);
        }
;
        for (int i = 0; i < path.length; i++) {
            System.out.print(i + " : ");
            int current = i;
            while (path[current] != 0) {
                current = path[current];
                System.out.print(current + " ");
            }
            System.out.println(0);
        }
    }
}
