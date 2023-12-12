package day07.Programmers.Search.Network;

import java.util.*;

/**
 * 너비 우선 탐색 방식
 */

class Solution {
    public void search(int[][] lists, boolean[] visited, Integer startNum) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        visited[startNum] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            int[] neighbors = lists[node];
            for (int i = 0; i < neighbors.length; i++) {
                if (!visited[i]) {
                    if (neighbors[i] == 1) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                answer += 1;
                search(computers, visited, i);
            }
        }
        return answer;
    }
}
