package day08.Dijkstra.Programmers.ShortestPath.TaxiJoin;

import java.util.Arrays;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72413
 *  프로그래머스 최단 거리 문제 [택시 합승]
 */

public class Solution {
    static final int INF = 10000;
    boolean[] visited;
    int[] costs;
    int[] path;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[] result = findPath(n, s, a, b, fares);
        int aCost = result[a-1];
        int bCost = result[b-1];

        System.out.println("A까지의 비용: " + aCost);
        System.out.println("B까지의 배용: " + bCost);

        for (int res : result) {
            System.out.print(res + " ");
        }
        return answer;
    }

    public int[] findPath(int n, int s, int a, int b, int[][] fares) {
        visited = new boolean[n];
        costs = new int[n];
        path = new int[n];

        Arrays.fill(costs, INF);

        int startNode = s - 1;
        costs[startNode] = 0;

        for (int i = 0; i < n-1; i++) {
            int minNode = findMinNode(costs, visited);

            visited[minNode] = true;

            for (int[] edge : fares) {
                int from = 0;
                int to = 0;
                int cost = 0;

                if (minNode == edge[0] - 1) {
                    from = edge[0] - 1;
                    to = edge[1] - 1;
                    cost = edge[2];
                } else if (minNode == edge[1] - 1) {
                    from = edge[1] - 1;
                    to = edge[0] - 1;
                    cost = edge[2];
                }

                if (!visited[to] && from == minNode && costs[from] + cost < costs[to]) {
                    costs[to] = costs[from] + cost;
                    path[to] = from;
                }
            }
        }
        return costs;
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
}
