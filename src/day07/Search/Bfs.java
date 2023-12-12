package day07.Search;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  너비 우선 탐색
 *
 * 	큐에 시작 노드를 넣는다
 * 	시작 노드를 방문처리
 * 	큐가 비어 있지 않으면 계속 반복
 * 		큐에서 노드을 하나 poll해서 가져온다
 * 		가져온 노드 출력
 * 		출력한 노드의 인접 노드들을 가져온다
 * 		인접 노드들이 방문한 적 없으면 큐에 넣고 방문 처리
 */

public class Bfs {
    public void search(List<List<Integer>> lists, Integer startNum) {
        boolean[] visited = new boolean[lists.size()];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        visited[startNum] = true;

        System.out.print("너비 우선 탐색 : ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            List<Integer> neighbors = lists.get(node);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }
    /*
        bfs.search(lists, 1);

        너비 우선 탐색 : 1 2 0 3 4

        bfs.search(lists, 0);

        너비 우선 탐색 : 0 4 3 1 2
    */

}
