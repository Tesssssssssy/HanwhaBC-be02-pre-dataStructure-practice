package day07.Search.Practice;

import java.util.*;

/**
 *  너비 우선 탐색 연습 용도 (예시 코드 보지 않고)
 */

public class BFS {
/*
        그래프를 2차원 리스트로 구현해보자.
        [
          [1, 3, 4],
          [0, 2],
          [1, 3],
          [0, 2, 4],
          [0, 3]
                     ]
*/
    public void BFS(List<List<Integer>> lists, int start) {
        // Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>(lists.size());
        for (int i = 0; i < lists.size(); i++) {
            visited.put(i, false);
        }

        // Queue queue = new LinkedList();
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visited.replace(start, true);

        System.out.print("너비 우선 탐색: ");
        while (!queue.isEmpty()) {
            // int nextNode = (int) queue.peek();
            int nextNode = queue.poll();
            System.out.print(nextNode + " ");

            /*
            if (visited.get(nextNode) == false) {
                visited.replace(nextNode, true);
            }
            */
            List<Integer> neighbors = lists.get(nextNode);
            for (int neighbor : neighbors) {
                if (visited.get(neighbor) == false) {
                    queue.add(neighbor);
                    visited.replace(neighbor, true);
                }
            }
        }
        System.out.println();
    }
}
