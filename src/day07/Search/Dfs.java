package day07.Search;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *         [
 *           [1, 3, 4],     0 -> 1, 3, 4 연결
 *           [0, 2],        1 -> 0, 2 연결
 *           [1, 3],        2 -> 1, 3 연결
 *           [0, 2, 4],     3 -> 0, 2, 4 연결
 *           [0, 3]         4 -> 0, 3 연결
 *                      ]
 */

/**
 * 깊이 우선 탐색
 *
 * 스택에 시작 노드를 넣는다
 * 	시작 노드를 방문처리
 * 	스택이 비어 있지 않으면 계속 반복
 * 		스택에서 노드을 하나 pop해서 가져온다
 * 		가져온 노드가 방문한 적 없으면
 * 			방문한 노드 출력
 * 			방문 처리
 *
 * 			방문한 노드의 인접 노드들을 가져온다
 * 			인접 노드들이 방문한 적 없으면 스택에 넣는다.
 */
public class Dfs {
    // 재귀 말고 stack을 이용해서 깊이 우선 탐색 메소드를 만들어보자.
    public void search(List<List<Integer>> lists, Integer startNum) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[lists.size()];

        stack.push(startNum);

        /*
            시작 노드부터 시작해서
            시작 노드를 스택에 담는다.
            시작 노드는 방문한 적이 없기 때문에
            스택에서 꺼내고 출력.
            시작 노드 방문 처리

            그리고 방문한 노드의 인접 노드들 중
            한 노드에 방문한다.
            스택에 넣고 해당 노드에 방문한 적이 없다면
            스택에서 꺼내고 출력.
            해당 노드 방문 처리.

            그리고 방문한 노드의 인접 노드들이 존재할 때까지 반복하는데
            만약 해당 노드에 방문한 적이 없다면
            스택에 넣고 위 과정 반복.
        */

        System.out.print("깊이 우선 탐색: ");
        while (!stack.isEmpty()) {
            Integer popInt = stack.pop();

            if (!visited[popInt]) {
                System.out.print(popInt + " ");
                visited[popInt] = true;
            }

            List<Integer> neighbors = lists.get(popInt);
            Collections.reverse(neighbors);
            // 역순으로 만들어줌.
            // 순서대로 넣었기 때문에 역순으로 해주는데 무작위로 넣었을 경우
            // 정렬 알고리즘을 여기서 적용하면 된다.

            for (Integer next : neighbors) {
                if (!visited[next]) {
                    stack.push(next);
                }
            }
        }
        System.out.println();
    }

    public void searchRecursive(List<List<Integer>> lists, Integer startNum) {
        System.out.print("깊이 우선 탐색 : ");
        searchRecursive(lists, startNum, new boolean[lists.size()]);
        // 여기서 새로운 boolean[] 객체를 생성해서 visited의 매개 변수로 보낸다.

        System.out.println("재귀 방식");
    }


    public void searchRecursive(List<List<Integer>> lists, int node, boolean[] visited) {
        if (!visited[node]) {
            System.out.print(node + " ");
            visited[node] = true;
            /*
                만약 해당 노드에 방문한 적이 없다면
                출력하고 해당 노드 방문 처리.
            */

            List<Integer> neighbors = lists.get(node);
            // 방문한 노드의 인접 노드들을 가져온다.

            Collections.reverse(neighbors);
            // 인접 노드들을 오름차순 정렬.

            for (int neighbor : neighbors) {
                searchRecursive(lists, neighbor, visited);
                // 모든 인접 노드들을 탐색하면서
                // 재귀적으로 함수 호출
            }
        }
    }
        /*
            dfs.search(lists, 1);

            깊이 우선 탐색: 1 0 3 2 4

            dfs.search(lists, 0);

            깊이 우선 탐색: 0 1 2 3 4
        */
}
