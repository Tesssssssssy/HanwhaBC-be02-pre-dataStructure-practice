package day08.Dijkstra.Ref;

import java.util.*;

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

public class Dijkstra {
    public void dijkstra(List<List<Edge>> graph, int start, int goal) {
        int[] minDistance = new int[graph.size()];
        // graph의 edge 개수 만큼 최단거리 배열 생성

        Arrays.fill(minDistance, Integer.MAX_VALUE);
        // 일단 최단거리 배열 minDistance의 모든 원소들을 무한대로 초기화

        minDistance[start] = 0;
        // 시작 노드의 최단 거리는 0

        Map<Integer, Integer> previousNode = new HashMap<>();
        // 이전 노드

        PriorityQueue<Map.Entry<Integer, Integer>> activeVertices = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        // 노드들을 방문하고 방문 처리를 해야 하는데
        // 탐색 속도를 높이기 위해 자동 정렬 기능이 제공하는 우선 순위 큐를 이전의 큐를 대신해 사용한다.

        activeVertices.add(new AbstractMap.SimpleEntry<>(0, start));

        while (!activeVertices.isEmpty()) {
            int where = activeVertices.poll().getValue();
            // 우선순위 큐에 있던 노드 뺴고 해당 노드 출력

            System.out.println("방문한 노드: " + where);
            printPath(previousNode, start, where);
            // 방문한 노드의 이전 노드 탐색 후 출력

            if (where == goal) {
                return;
                // 목적지 노드에 도착하면 종료.
            }

            for (Edge ed : graph.get(where)) {
                if (minDistance[ed.to] > minDistance[where] + ed.length) {
                    activeVertices.remove(new AbstractMap.SimpleEntry<>(minDistance[ed.to], ed.to));
                    minDistance[ed.to] = minDistance[where] + ed.length;
                    previousNode.put(ed.to, where); // Update previous node
                    activeVertices.add(new AbstractMap.SimpleEntry<>(minDistance[ed.to], ed.to));
                }
            }
        }
        System.out.println("최단 경로를 찾을 수 없습니다. from " + start + " to " + goal);
    }

    public void printPath(Map<Integer, Integer> previousNode, int start, int goal) {
        List<Integer> path = new ArrayList<>();
        int current = goal;

        while (current != start) {
            // goal이 current이니까 거꾸고 start가 될 때까지
            // 해당 노드에 오기까지 거쳤던 노드들을 path에 추가

            path.add(current);
            current = previousNode.get(current);
        }

        path.add(start);
        Collections.reverse(path);

        System.out.print("현재 경로: ");
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println("\n");
    }
}
