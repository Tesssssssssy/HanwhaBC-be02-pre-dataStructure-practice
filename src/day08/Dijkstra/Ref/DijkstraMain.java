package day08.Dijkstra.Ref;

import java.util.ArrayList;
import java.util.List;

/**
 *      [0, 3, 7]   ->   0---(7)---3
 *      [0, 1, 8]   ->   0---(8)---1
 *      [0, 4, 2]   ->   0---(2)---4
 *
 *      [1, 5, 1]   ->   1---(1)---5
 *
 *      [3. 5. 8]   ->   3---(8)---5
 *      [3, 7, 9]   ->   3---(9)---7

 *      [4, 6, 2]   ->   4---(2)---6
 *
 *      [5, 7, 4]   ->   5---(4)---7
 *
 *      [6, 2, 7]   ->   6---(7)---2
 *      [6, 7, 5]   ->   6---(5)---7
 */

public class DijkstraMain {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        List<List<Edge>> graph = new ArrayList<>();
        int numNodes = 8; // 그래프의 노드 수

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 추가 (실제 데이터에 맞게 수정 필요)
        graph.get(0).add(new Edge(3, 7));
        graph.get(0).add(new Edge(1, 8));
        graph.get(0).add(new Edge(4, 2));

        graph.get(1).add(new Edge(5, 1));

        graph.get(3).add(new Edge(5, 8));
        graph.get(3).add(new Edge(7, 9));

        graph.get(4).add(new Edge(6, 2));

        graph.get(5).add(new Edge(6, 2));

        graph.get(6).add(new Edge(2, 7));
        graph.get(6).add(new Edge(7, 5));

        int start = 0;
        int goal = 7;

        dijkstra.dijkstra(graph, start, goal);
    }
    /*
            방문한 노드: 0
            현재 경로: 0
            방문한 노드: 4
            현재 경로: 0 4
            방문한 노드: 6
            현재 경로: 0 4 6
            방문한 노드: 3
            현재 경로: 0 3
            방문한 노드: 1
            현재 경로: 0 1
            방문한 노드: 7
            현재 경로: 0 4 6 7
    */
}

