package day07.Search;

import java.util.ArrayList;
import java.util.List;

public class DfsMyVer {
    public void DFS(List<List<Integer>> lists, int start) {
        List<Boolean> visited = new ArrayList<>(lists.size());
        for (int i = 0; i < lists.size(); i++) {
            visited.add(false);
        }
        /*
            초기값으로 처음엔 다 방문하지 않은 것으로 setting
        */
        recursiveDFS(lists, visited, start);
    }

    public void recursiveDFS(List<List<Integer>> lists, List<Boolean> visited, int start) {
        if (visited.get(start)) {
            return;
            /*
                start가 가본 곳이면 (true이면) 끝
            */
        } else {
            System.out.print(start + " ");
            visited.set(start, true);
            /*
                시작 노드에 방문한 적이 없다면
                출력하고 시작 노드 방문 처리.
            */

            for (Integer e : lists.get(start)) {
                recursiveDFS(lists, visited, e);
            }
            /*
                시작 노드의 인접 노드들을 탐색하면서
                재귀적으로 함수 호출
            */
            return;
        }
    }
}
