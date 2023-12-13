package day07.Search.Practice;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDFS {
    public void recursiveDFS(List<List<Integer>> lists, int start) {
        List<Boolean> visited = new ArrayList<>(lists.size());
        for (int i = 0; i < lists.size(); i++) {
            visited.add(false);
        }
        System.out.print("깊이 우선 탐색 재귀: ");
        recursiveDFS(lists, start, visited);
        System.out.println();
    }

    public void recursiveDFS(List<List<Integer>> lists, int next, List<Boolean> visited) {
        if (visited.get(next)) {
            return;
        } else {
            System.out.print(next + " ");
            visited.set(next, true);

            for (int neighbor : lists.get(next)) {
                recursiveDFS(lists, neighbor, visited);
            }
        }
       return;
    }
}
