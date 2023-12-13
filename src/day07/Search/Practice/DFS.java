package day07.Search.Practice;

import java.util.*;

public class DFS {
    public void DFS(List<List<Integer>> lists, int start) {
        Map<Integer, Boolean> visited = new HashMap<>(lists.size());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < lists.size(); i++) {
            visited.put(i, false);
        }

        stack.push(start);

        System.out.print("깊이 우선 탐색: ");
        while (!stack.isEmpty()) {
            int nextNode = stack.pop();

            if (visited.get(nextNode) == false) {
                System.out.print(nextNode + " ");
                visited.replace(nextNode, true);
            }

            /*
                List<Integer> neighbors = lists.get(nextNode);
                Collections.reverse(neighbors);

                문제는 DFS 구현에서 Collections.reverse(neighbors)를 사용할 때 발생.
                이 코드는 이웃 목록을 뒤집어서 순서를 변경하는데,
                이로 인해 DFS의 후속 반복에 영향을 미친다.
                이 문제를 해결하려면 원래의 목록을 수정하지 않도록 해야한다.
                다음은 DFS 클래스를 수정한 코드
                기존 목록을 수정하는 대신 새로운 ArrayList neighbors를 만들어
                원래의 목록에 영향을 미치지 않도록 했다.
                이렇게 하면 올바른 DFS 결과를 얻을 수 있다.

                원래의 그래프 인접 리스트 예시:
                [1, 3, 4]
                [0, 2]
                [1, 3]
                [0, 2, 4]
                [0, 3]

                초기 스택에 0을 넣고 방문 표시.
                스택에서 0을 꺼내고, 이웃 노드를 1, 3, 4 순서로 방문.
                Collections.reverse(neighbors)를 통해 이웃 노드가 4, 3, 1로 변경됨.
                스택에는 4, 3, 1이 순서대로 들어감.
                이 때, 스택에서 1을 꺼내면 다음 순서대로 이웃 노드를 방문해야 함: 0, 4, 3, 2 (그래프의 구조 상).

                하지만 Collections.reverse(neighbors)로 인해 이웃 노드가 2, 3, 4로 순서가 변경되었기 때문에
                스택에서 나온 노드의 이웃 노드를 역순으로 방문하게 됩니다. 결과적으로 올바르지 않은 DFS 결과가 나온다.

                따라서, 원래의 목록을 변경하지 않고 새로운 리스트를 생성하여 역순을 적용하면 올바른 DFS 결과를 얻을 수 있다.
            */

            List<Integer> neighbors = new ArrayList<>(lists.get(nextNode));
            Collections.reverse(neighbors);

            for (int neighbor : neighbors) {
                if (visited.get(neighbor) == false) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}
