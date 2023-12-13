package day07.Search.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  너비 우선 탐색 연습 용도 (예시 코드 보지 않고)
 */

public class Main {
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
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> list0 = Arrays.asList(1, 3, 4);
        List<Integer> list1 = Arrays.asList(0, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(0, 2, 4);
        List<Integer> list4 = Arrays.asList(0, 3);

        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        RecursiveDFS recursiveDFS = new RecursiveDFS();
        recursiveDFS.recursiveDFS(lists, 0);
        // 깊이 우선 탐색 재귀: 0 1 2 3 4

        recursiveDFS.recursiveDFS(lists, 1);
        // 깊이 우선 탐색 재귀: 1 0 3 2 4

        BFS bfs = new BFS();
        bfs.BFS(lists, 0);
        // 너비 우선 탐색: 0 1 3 4 2

        bfs.BFS(lists, 1);
        // 너비 우선 탐색: 1 0 2 3 4

        DFS dfs = new DFS();
        dfs.DFS(lists, 0);
        // 깊이 우선 탐색: 0 1 2 3 4


        dfs.DFS(lists, 1);
        // 깊이 우선 탐색: 1 0 3 2 4
    }
}
