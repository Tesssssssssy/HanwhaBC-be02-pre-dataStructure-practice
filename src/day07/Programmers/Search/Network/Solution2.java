package day07.Programmers.Search.Network;

/**
 * 깊이 우선 탐색 + 재귀를 이용한 방식
 */

public class Solution2 {
    public void searchRecursive(int[][] lists, int node, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;

            for (int i = 0; i < lists.length; i++) {
                if (lists[node][i] == 1) {
                    searchRecursive(lists, i, visited);
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false) {
                answer = answer + 1;
                searchRecursive(computers, i, visited);
            }
        }
        return answer;
    }
}
