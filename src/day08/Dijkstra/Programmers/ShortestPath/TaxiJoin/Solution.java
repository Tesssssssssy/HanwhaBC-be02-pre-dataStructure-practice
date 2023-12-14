package day08.Dijkstra.Programmers.ShortestPath.TaxiJoin;

import java.util.Arrays;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72413
 *  프로그래머스 최단 거리 문제 [택시 합승]
 */

public class Solution {
    static final int INF = 200*100000+1;
    boolean[] visited;
    int[] costs;
    int[] path;

    public int[] findPath(int N, int s, int[][] graph) {
        visited = new boolean[N];
        costs = new int[N];
        path = new int[N];

        Arrays.fill(costs, INF);

        int startNode = s-1;
        costs[startNode] = 0;

        for (int i = 0; i < N - 1; i++) {
            int minNode = findMinNode(costs, visited);

            visited[minNode] = true;

            for (int[] edge : graph) {
                int from;
                int to;
                int cost;
                from = 0;
                to=0;
                cost=0;

                if(minNode == edge[0]-1) {
                    from = edge[0]-1;
                    to = edge[1]-1;
                    cost = edge[2];
                } else if(minNode == edge[1]-1) {
                    from = edge[1]-1;
                    to = edge[0]-1;
                    cost = edge[2];
                }

                if (!visited[to] && from == minNode && costs[from] != INF && costs[from] + cost < costs[to]) {
                    costs[to] = costs[from] + cost;
                    path[to] = from;
                }
            }
        }
        return costs;
    }
    private int findMinNode(int[] costs, boolean[] visited) {
        int minCost = INF;
        int minNode = 0;

        for (int i = 0; i < costs.length; i++) {
            if (!visited[i] && costs[i] < minCost) {
                minCost = (int) costs[i];
                minNode = i;
            }
        }

        return minNode;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;

        int[] startA = findPath(n, a, fares);
        int[] startB = findPath(n, b, fares);
        int[] start = findPath(n, s, fares);

        for(int i=1;i<n;i++) {

            answer = Math.min(answer, startA[i]+startB[i]+start[i]);
        }

        return answer;
    }
}

